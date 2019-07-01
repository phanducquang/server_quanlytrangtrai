package tk.giaiphapchannuoi.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tk.giaiphapchannuoi.server.security.CustomUserDetailsService;
import tk.giaiphapchannuoi.server.security.JwtAuthenticationEntryPoint;
import tk.giaiphapchannuoi.server.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .antMatchers("/auth/login","/auth/keepawake")
                        .permitAll()
                    .antMatchers(HttpMethod.GET,"/api/schedule/list","/api/schedule/listschedule","/api/schedule/one/**","/api/schedule/employee/**","/api/farms/list","/api/sections/list","/api/houses/list","/api/settings/list")
                        .permitAll()
                    .antMatchers(HttpMethod.GET,"/auth/check_login")
                        .hasAnyRole("admin","nhan_vien")
                //tong_quan_trang_trai
                    .antMatchers(HttpMethod.GET,"/api/farms/one/**")
                        .hasAnyRole("xem_thong_tin_trang_trai","admin")
                    .antMatchers(HttpMethod.PUT,"/api/farms/")
                        .hasAnyRole("cap_nhat_trang_trai","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/farms/")
                        .hasAnyRole("xoa_trang_trai","admin")
                    .antMatchers(HttpMethod.POST,"/api/farms/")
                        .hasAnyRole("them_trang_trai","admin")
                //tong_quan_khu
                    .antMatchers(HttpMethod.POST,"/api/sections/")
                        .hasAnyRole("them_khu","admin")
                    .antMatchers(HttpMethod.GET,"/api/sections/one/**")
                        .hasAnyRole("xem_thong_tin_khu","admin")
                    .antMatchers(HttpMethod.PUT,"/api/sections/")
                        .hasAnyRole("cap_nhat_khu","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/sections/")
                        .hasAnyRole("xoa_khu","admin")
                    .antMatchers(HttpMethod.POST,"/api/houses/")
                        .hasAnyRole("them_chuong","admin")
                    .antMatchers(HttpMethod.GET,"/api/houses/one/**")
                        .hasAnyRole("xem_thong_tin_chuong","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/houses/")
                        .hasAnyRole("xoa_chuong","admin")
                //quan_ly_danh_sach_heo
                    .antMatchers(HttpMethod.POST,"/api/pigs/")
                        .hasAnyRole("them_heo","admin")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasAnyRole("cap_nhat_thong_tin_heo","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/pigs/")
                        .hasAnyRole("xoa_heo","admin")
                    .antMatchers(HttpMethod.GET,"/api/piginfoextend/")
                        .hasAnyRole("xem_lich_su_hoat_dong","admin")
                //quan_ly_danh_sach_nhan_vien
                    .antMatchers(HttpMethod.GET,"/api/employees/list")
                        .hasAnyRole("xem_danh_sach_nhan_vien","admin")
                    .antMatchers(HttpMethod.POST,"/api/employees/")
                        .hasAnyRole("them_nhan_vien","admin")
                    .antMatchers(HttpMethod.PUT,"/api/employees/")
                        .hasAnyRole("cap_nhat_nhan_vien","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/employees/")
                        .hasAnyRole("xoa_nhan_vien","admin")
                    .antMatchers(HttpMethod.GET,"/api/employees/one/**")
                        .hasAnyRole("xem_thong_tin_nhan_vien","admin")
                //quan_ly_danh_sach_doi_tac
                    .antMatchers(HttpMethod.GET,"/api/partners/list")
                        .hasAnyRole("xem_danh_sach_doi_tac","thiet_lap_danh_sach_doi_tac","admin")
                    .antMatchers(HttpMethod.POST,"/api/partners/")
                        .hasAnyRole("them_doi_tac","thiet_lap_danh_sach_doi_tac","admin")
                    .antMatchers(HttpMethod.PUT,"/api/partners/")
                        .hasAnyRole("cap_nhat_doi_tac","thiet_lap_danh_sach_doi_tac","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/partners/")
                        .hasAnyRole("xoa_doi_tac","thiet_lap_danh_sach_doi_tac","admin")
                    .antMatchers(HttpMethod.GET,"/api/partners/one/**")
                        .hasAnyRole("xem_thong_tin_doi_tac","thiet_lap_danh_sach_doi_tac","admin")
                //quan_ly_danh_sach_kho
                    .antMatchers(HttpMethod.GET,"/api/warehouses/list")
                        .hasAnyRole("xem_danh_sach_kho","admin")
                    .antMatchers(HttpMethod.POST,"/api/warehouses/")
                        .hasAnyRole("them_kho","admin")
                    .antMatchers(HttpMethod.PUT,"/api/warehouses/")
                        .hasAnyRole("cap_nhat_kho","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/warehouses/")
                        .hasAnyRole("xoa_kho","admin")
                    .antMatchers(HttpMethod.GET,"/api/warehouses/one/**")
                        .hasAnyRole("xem_thong_tin_kho","admin")
                    .antMatchers(HttpMethod.GET,"/api/feeds/feedlist/")
                        .hasAnyRole("xuat_cam_cho_heo_an","admin")
                    .antMatchers(HttpMethod.GET,"//api/feeds/feedlist/")
                        .hasAnyRole("xem_lich_su_xuat_cam","admin")
                //quan_ly_danh_sach_chung_tu
                    .antMatchers(HttpMethod.GET,"/api/invoices/list")
                        .hasAnyRole("xem_danh_sach_chung_tu","admin")
                    .antMatchers(HttpMethod.POST,"/api/invoicespig/")
                        .hasAnyRole("them_chung_tu_nhap_heo_trong_he_thong","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicespig/")
                        .hasAnyRole("xoa_chung_tu_nhap_heo_trong_he_thong","xoa_chung_tu_xuat_ban_heo","admin")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasAnyRole("cap_nhat_chung_tu_nhap_heo_trong_he_thong","xac_nhan_hoan_tat_chung_tu_xuat_ban_heo","cap_nhat_chung_tu_xuat_ban_heo","admin")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasAnyRole("xac_nhan_hoan_tat_chung_tu_nhap_heo_trong_he_thong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasAnyRole("danh_gia_lai_heo_thuoc_chung_tu_nhap_heo_trong_he_thong","admin")
                    .antMatchers(HttpMethod.POST,"/api/invoicespig/")
                        .hasAnyRole("them_chung_tu_nhap_heo_ngoai_he_thong","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicespig/")
                        .hasAnyRole("xoa_chung_tu_nhap_heo_ngoai_he_thong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasAnyRole("cap_nhat_chung_tu_nhap_heo_ngoai_he_thong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasAnyRole("xac_nhan_hoan_tat_chung_tu_nhap_heo_ngoai_he_thong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasAnyRole("danh_gia_lai_heo_thuoc_chung_tu_nhap_heo_ngoai_he_thong","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicepigdetail/")
                        .hasAnyRole("xoa_chi_tiet_chung_tu_nhap_heo_ngoai_he_thong","admin")
                    .antMatchers(HttpMethod.POST,"/api/invoicespig/")
                        .hasAnyRole("them_chung_tu_xuat_heo_trong_he_thong","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicespig/")
                        .hasAnyRole("xoa_chung_tu_xuat_heo_trong_he_thong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasAnyRole("cap_nhat_chung_tu_xuat_heo_trong_he_thong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasAnyRole("xac_nhan_xuat_heo_chung_tu_xuat_heo_trong_he_thong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasAnyRole("danh_gia_lai_heo_thuoc_chung_tu_xuat_heo_trong_he_thong","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicepigdetail/onlyinvoicedetail/")
                        .hasAnyRole("xoa_chi_tiet_chung_tu_xuat_heo_trong_he_thong","xoa_chi_tiet_chung_tu_xuat_ban_heo","admin")
                    .antMatchers(HttpMethod.POST,"/api/invoicesproduct/")
                        .hasAnyRole("them_chung_nhap_cam","them_chung_nhap_thuoc","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicesproduct/")
                        .hasAnyRole("xoa_chung_tu_nhap_cam","xoa_chung_tu_nhap_thuoc","admin")
                    .antMatchers(HttpMethod.PUT,"/api/invoicesproduct/")
                        .hasAnyRole("xac_nhan_hoan_tat_chung_tu_nhap_cam","xac_nhan_hoan_tat_chung_tu_nhap_thuoc","cap_nhat_chung_tu_nhap_cam","cap_nhat_chung_tu_nhap_thuoc","admin")
                    .antMatchers(HttpMethod.POST,"/api/foodwarehouse/")
                        .hasAnyRole("them_chi_tiet_chung_tu_nhap_cam","admin")
                    .antMatchers(HttpMethod.PUT,"/api/foodwarehouse/")
                        .hasAnyRole("cap_nhat_chi_tiet_chung_tu_nhap_cam","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/foodwarehouse/")
                        .hasAnyRole("xoa_chi_tiet_chung_tu_nhap_cam","admin")
                    .antMatchers(HttpMethod.POST,"/api/medicinewarehouse/")
                        .hasAnyRole("them_chi_tiet_chung_tu_nhap_thuoc","admin")
                    .antMatchers(HttpMethod.PUT,"/api/medicinewarehouse/")
                        .hasAnyRole("cap_nhat_chi_tiet_chung_tu_nhap_thuoc","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/medicinewarehouse/")
                        .hasAnyRole("xoa_chi_tiet_chung_tu_nhap_thuoc","admin")
                //quan_ly_hoat_dong

                    .antMatchers(HttpMethod.GET,"/api/pigs/one/**")
                        .hasAnyRole("xem_thong_tin_heo","xem_thong_tin_heo_tai_khu","admin")
                    .antMatchers(HttpMethod.POST,"/api/issuespigs/")
                        .hasAnyRole("nhap_van_de_cua_heo","admin")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasAnyRole("danh_gia_chuyen_noi_bo","admin")
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasAnyRole("xem_danh_sach_heo","admin")
                    .antMatchers(HttpMethod.POST,"/api/breedings/")
                        .hasAnyRole("len_giong_heo_nai","admin")
                    .antMatchers(HttpMethod.PUT,"/api/breedings/")
                        .hasAnyRole("cap_nhat_thong_tin_len_giong","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/breedings/")
                        .hasAnyRole("xoa_thong_tin_len_giong","admin")
                    .antMatchers(HttpMethod.GET,"/api/breedings/list")
                        .hasAnyRole("xem_danh_sach_len_giong","admin")
                    .antMatchers(HttpMethod.POST,"/api/sperm/")
                        .hasAnyRole("khai_thac_tinh_heo","admin")
                    .antMatchers(HttpMethod.PUT,"/api/sperm/")
                        .hasAnyRole("cap_nhat_thong_tin_khai_thac_tinh_heo","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/sperm/")
                        .hasAnyRole("xoa_thong_tin_khai_thac_tinh_heo","admin")
                    .antMatchers(HttpMethod.GET,"/api/sperm/list")
                        .hasAnyRole("xem_danh_sach_khai_thac_tinh_heo","admin")
                    .antMatchers(HttpMethod.POST,"/api/matings/matingsmatingdetails/")
                        .hasAnyRole("ghi_nhan_phoi_giong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/matings/matingsmatingdetails/")
                        .hasAnyRole("cap_nhat_thong_tin_phoi_giong","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/matings/")
                        .hasAnyRole("xoa_thong_tin_phoi_giong","admin")
                    .antMatchers(HttpMethod.GET,"/api/matings/matingsmatingdetails/list")
                        .hasAnyRole("xem_danh_sach_phoi_giong","admin")
                    .antMatchers(HttpMethod.PUT,"/api/matings/")
                        .hasAnyRole("xac_nhan_heo_mang_thai","admin")
                    .antMatchers(HttpMethod.PUT,"/api/matings/")
                        .hasAnyRole("xac_nhan_heo_say_thai","admin")
                    .antMatchers(HttpMethod.POST,"/api/births/")
                        .hasAnyRole("ghi_nhan_thong_tin_heo_de","admin")
                    .antMatchers(HttpMethod.PUT,"/api/births/")
                        .hasAnyRole("cap_nhat_thong_tin_heo_de","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/births/")
                        .hasAnyRole("xoa_ghi_nhan_thong_tin_heo_de","admin")
                    .antMatchers(HttpMethod.POST,"/api/invoicepigdetail/pigsinvoicepigdetail/")
                        .hasAnyRole("them_chi_tiet_chung_tu_xuat_heo_trong_he_thong","them_chi_tiet_chung_tu_nhap_heo_ngoai_he_thong","nhap_heo_con","admin")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasAnyRole("them_vao_danh_sach_cai_sua","admin")
                //thiet_lap_trang_thai_mang_thai
                    .antMatchers(HttpMethod.GET,"/api/pregnancystatus/**")
                        .hasAnyRole("thiet_lap_trang_thai_mang_thai","admin")
                    .antMatchers("/api/pregnancystatus/")
                        .hasAnyRole("thiet_lap_trang_thai_mang_thai","admin")
                //thiet_lap_danh_sach_giong
                    .antMatchers(HttpMethod.GET,"/api/breeds/**")
                        .hasAnyRole("thiet_lap_danh_sach_giong","admin")
                    .antMatchers("/api/breeds/")
                        .hasAnyRole("thiet_lap_danh_sach_giong","admin")
                //thiet_lap_loai_len_giong
                    .antMatchers(HttpMethod.GET,"/api/breedingtype/**")
                        .hasAnyRole("thiet_lap_loai_len_giong","admin")
                    .antMatchers("/api/breedingtype/")
                        .hasAnyRole("thiet_lap_loai_len_giong","admin")
                //thiet_lap_trang_thai_suc_khoe
                    .antMatchers(HttpMethod.GET,"/api/healthstatus/**")
                        .hasAnyRole("thiet_lap_trang_thai_suc_khoe","admin")
                    .antMatchers("/api/healthstatus/")
                        .hasAnyRole("thiet_lap_trang_thai_suc_khoe","admin")
                //thiet_lap_danh_sach_benh
                    .antMatchers(HttpMethod.GET,"/api/diseases/**")
                        .hasAnyRole("thiet_lap_danh_sach_benh","admin")
                    .antMatchers("/api/diseases/")
                        .hasAnyRole("thiet_lap_danh_sach_benh","admin")
                //thiet_lap_danh_sach_loai_trang_trai
                    .antMatchers(HttpMethod.GET,"/api/farmtypes/**")
                        .hasAnyRole("thiet_lap_danh_sach_loai_trang_trai","admin")
                    .antMatchers("/api/farmtypes/")
                        .hasAnyRole("thiet_lap_danh_sach_loai_trang_trai","admin")
                //thiet_lap_danh_sach_loai_thuc_an
                    .antMatchers(HttpMethod.GET,"/api/foodtype/**")
                        .hasAnyRole("thiet_lap_danh_sach_loai_thuc_an","admin")
                    .antMatchers("/api/foodtype/")
                        .hasAnyRole("thiet_lap_danh_sach_loai_thuc_an","admin")
                //thiet_lap_don_vi_cam
                    .antMatchers(HttpMethod.GET,"/api/foodunits/**")
                        .hasAnyRole("thiet_lap_don_vi_cam","admin")
                    .antMatchers("/api/foodunits/")
                        .hasAnyRole("thiet_lap_don_vi_cam","admin")
                //thiet_lap_danh_sach_cam
                    .antMatchers(HttpMethod.GET,"/api/foods/**")
                        .hasAnyRole("thiet_lap_danh_sach_cam","admin")
                    .antMatchers("/api/foods/")
                        .hasAnyRole("thiet_lap_danh_sach_cam","admin")
                //thiet_lap_nhom_thuoc
                    .antMatchers(HttpMethod.GET,"/api/medicinetype/**")
                        .hasAnyRole("thiet_lap_nhom_thuoc","admin")
                    .antMatchers("/api/medicinetype/")
                        .hasAnyRole("thiet_lap_nhom_thuoc","admin")
                //thiet_lap_danh_sach_thuoc
                    .antMatchers(HttpMethod.GET,"/api/medicines/**")
                        .hasAnyRole("thiet_lap_danh_sach_thuoc","admin")
                    .antMatchers("/api/medicines/")
                        .hasAnyRole("thiet_lap_danh_sach_thuoc","admin")
//                //thiet_lap_danh_sach_ma_san_pham
//                    .antMatchers(HttpMethod.GET,"/api/settings/list")
//                        .hasAnyRole("thiet_lap_danh_sach_ma_san_pham","admin")
                //thiet_lap_loai_chan
                    .antMatchers(HttpMethod.GET,"/api/foottype/**")
                        .hasAnyRole("thiet_lap_loai_chan","admin")
                    .antMatchers("/api/foottype/")
                        .hasAnyRole("thiet_lap_loai_chan","admin")
                //thiet_lap_loai_bo_phan_sinh_duc
                    .antMatchers(HttpMethod.GET,"/api/gentialtype/**")
                        .hasAnyRole("thiet_lap_loai_bo_phan_sinh_duc","admin")
                    .antMatchers("/api/gentialtype/")
                        .hasAnyRole("thiet_lap_loai_bo_phan_sinh_duc","admin")
                //thiet_lap_danh_sach_trang_thai_heo
                    .antMatchers(HttpMethod.GET,"/api/status/**")
                        .hasAnyRole("thiet_lap_danh_sach_trang_thai_heo","admin")
                    .antMatchers("/api/status/")
                        .hasAnyRole("thiet_lap_danh_sach_trang_thai_heo","admin")
                //thiet_lap_danh_sach_chuc_vu
                    .antMatchers(HttpMethod.GET,"/api/regencies/**")
                        .hasAnyRole("thiet_lap_danh_sach_chuc_vu","admin")
                    .antMatchers("/api/regencies/")
                        .hasAnyRole("thiet_lap_danh_sach_chuc_vu","admin")
                //thiet_lap_luat_phoi
                    .antMatchers(HttpMethod.GET,"/api/matingroles/**")
                        .hasAnyRole("thiet_lap_luat_phoi","admin")
                    .antMatchers("/api/matingroles/")
                        .hasAnyRole("thiet_lap_luat_phoi","admin")
                //thiet_lap_luat_phoi
                    .antMatchers(HttpMethod.GET,"/api/matingroles/**")
                        .hasAnyRole("thiet_lap_luat_phoi","admin")
                    .antMatchers("/api/matingroles/")
                        .hasAnyRole("thiet_lap_luat_phoi","admin")
                //quan_ly_danh_sach_nhan_vien
                    .antMatchers(HttpMethod.GET,"/api/users/employee/**")
                        .hasAnyRole("xem_danh_sach_tai_khoan_nhan_vien","admin")
                //quan_ly_danh_sach_chung_tu
                    .antMatchers(HttpMethod.GET,"/api/invoicespig/forwarding/list")
                        .hasAnyRole("xem_danh_chung_tu_chuyen_heo_den","admin")
                //quan_ly_hoat_dong
                    .antMatchers(HttpMethod.GET,"/api/minings/**")
                        .hasAnyRole("phan_loai_danh_gia_chat_luong_heo","admin")
                    .antMatchers(HttpMethod.GET,"/api/minings/update/**")
                        .hasAnyRole("luu_ghi_nhan_danh_gia_chat_luong_heo","admin")
                    .antMatchers(HttpMethod.GET,"/api/births/list")
                        .hasAnyRole("xem_danh_sach_ghi_nhan_heo_de","admin")
                //quan_ly_lam_san
                    .antMatchers(HttpMethod.GET,"/api/issuespigs/list")
                        .hasAnyRole("xem_danh_sach_ghi_nhan_van_de_heo","admin")
                    .antMatchers(HttpMethod.GET,"/api/issuespigs/forecastdiseases/**")
                        .hasAnyRole("xem_goi_y_chuan_doan","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/issuespigs/")
                        .hasAnyRole("xoa_ghi_nhan_van_de_heo","admin")
                    .antMatchers(HttpMethod.POST,"/api/usedmedicine/")
                        .hasAnyRole("xu_ly_van_de_heo","admin")
                    .antMatchers(HttpMethod.PUT,"/api/issuespigs/updateall/")
                        .hasAnyRole("xac_nhan_hoan_tat_xu_ly","admin")
                //quan_ly_bang_ke_hoach
                    .antMatchers(HttpMethod.GET,"/api/schedule/listschedule")
                        .hasAnyRole("xem_bang_ke_hoach","admin")
                    .antMatchers(HttpMethod.POST,"/api/schedule/")
                        .hasAnyRole("tao_moi_ke_hoach","admin")
                    .antMatchers(HttpMethod.DELETE,"/api/schedule/")
                        .hasAnyRole("xoa_ke_hoach","admin")
                    .antMatchers(HttpMethod.PUT,"/api/schedule/")
                        .hasAnyRole("xac_nhan_hoan_tat_ke_hoach","admin")
                    .antMatchers(HttpMethod.GET,"/api/mail/sendemailnotification/")
                        .hasAnyRole("gui_thong_bao_ke_hoach","admin")
                //quan_ly_thiet_lap
                    .antMatchers("/api/warehousetype/")
                        .hasAnyRole("thiet_lap_danh_sach_loai_kho","admin")
                    .antMatchers("/api/customertypes/")
                        .hasAnyRole("thiet_lap_danh_sach_loai_khach_hang","admin")
                    .antMatchers("/api/customergroups/")
                        .hasAnyRole("thiet_lap_danh_sach_nhom_khach_hang","admin")
                    .antMatchers("/api/customers/")
                        .hasAnyRole("thiet_lap_danh_sach_khach_hang","admin")
                    .antMatchers("/api/medicineunits/")
                        .hasAnyRole("thiet_lap_danh_sach_don_vi_thuoc","admin")
                    .antMatchers("/api/issues/")
                        .hasAnyRole("thiet_lap_danh_sach_trieu_chung_lam_San","admin")
                    .antMatchers("/api/roles/")
                        .hasAnyRole("thiet_lap_danh_sach_phan_quyen","admin");

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}