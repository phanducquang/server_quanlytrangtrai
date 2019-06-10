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
                //tong_quan_trang_trai
                    .antMatchers(HttpMethod.GET,"/api/farms/list")
                        .hasRole("xem_danh_sach_trang_trai")
                    .antMatchers(HttpMethod.GET,"/api/farms/**")
                        .hasRole("xem_thong_tin_trang_trai")
                    .antMatchers(HttpMethod.PUT,"/api/farms/")
                        .hasRole("cap_nhat_trang_trai")
                    .antMatchers(HttpMethod.DELETE,"/api/farms/")
                        .hasRole("xoa_trang_trai")
                    .antMatchers(HttpMethod.POST,"/api/farms/")
                        .hasRole("them_trang_trai")
                //tong_quan_khu
                    .antMatchers(HttpMethod.POST,"/api/sections/")
                        .hasRole("them_khu")
                    .antMatchers(HttpMethod.GET,"/api/sections/list")
                        .hasRole("xem_danh_sach_khu")
                    .antMatchers(HttpMethod.GET,"/api/sections/**")
                        .hasRole("xem_thong_tin_khu")
                    .antMatchers(HttpMethod.PUT,"/api/sections/")
                        .hasRole("cap_nhat_khu")
                    .antMatchers(HttpMethod.DELETE,"/api/sections/")
                        .hasRole("xoa_khu")
                    .antMatchers(HttpMethod.POST,"/api/houses/")
                        .hasRole("them_chuong")
                    .antMatchers(HttpMethod.GET,"/api/houses/list")
                        .hasRole("xem_danh_sach_chuong")
                    .antMatchers(HttpMethod.GET,"/api/houses/**")
                        .hasRole("xem_thong_tin_chuong")
                    .antMatchers(HttpMethod.DELETE,"/api/houses/")
                        .hasRole("xoa_chuong")
                //quan_ly_danh_sach_heo
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("xem_danh_sach_heo")
                    .antMatchers(HttpMethod.POST,"/api/pigs/")
                        .hasRole("them_heo")
                    .antMatchers(HttpMethod.GET,"/api/pigs/**")
                        .hasRole("xem_thong_tin_heo")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasRole("cap_nhat_thong_tin_heo")
                    .antMatchers(HttpMethod.DELETE,"/api/pigs/")
                        .hasRole("xoa_heo")
                    .antMatchers(HttpMethod.GET,"/api/piginfoextend/")
                        .hasRole("xem_lich_su_hoat_dong")
                //quan_ly_danh_sach_nhan_vien
                    .antMatchers(HttpMethod.GET,"/api/employees/list")
                        .hasRole("xem_danh_sach_nhan_vien")
                    .antMatchers(HttpMethod.POST,"/api/employees/")
                        .hasRole("them_nhan_vien")
                    .antMatchers(HttpMethod.PUT,"/api/employees/")
                        .hasRole("cap_nhat_nhan_vien")
                    .antMatchers(HttpMethod.DELETE,"/api/employees/")
                        .hasRole("xoa_nhan_vien")
                    .antMatchers(HttpMethod.GET,"/api/employees/**")
                        .hasRole("xem_thong_tin_nhan_vien")
                //quan_ly_danh_sach_doi_tac
                    .antMatchers(HttpMethod.GET,"/api/partners/list")
                        .hasRole("xem_danh_sach_doi_tac")
                    .antMatchers(HttpMethod.POST,"/api/partners/")
                        .hasRole("them_doi_tac")
                    .antMatchers(HttpMethod.PUT,"/api/partners/")
                        .hasRole("cap_nhat_doi_tac")
                    .antMatchers(HttpMethod.DELETE,"/api/partners/")
                        .hasRole("xoa_doi_tac")
                    .antMatchers(HttpMethod.GET,"/api/partners/**")
                        .hasRole("xem_thong_tin_doi_tac")
                //quan_ly_danh_sach_kho
                    .antMatchers(HttpMethod.GET,"/api/warehouses/list")
                        .hasRole("xem_danh_sach_kho")
                    .antMatchers(HttpMethod.POST,"/api/warehouses/")
                        .hasRole("them_kho")
                    .antMatchers(HttpMethod.PUT,"/api/warehouses/")
                        .hasRole("cap_nhat_kho")
                    .antMatchers(HttpMethod.DELETE,"/api/warehouses/")
                        .hasRole("xoa_kho")
                    .antMatchers(HttpMethod.GET,"/api/warehouses/**")
                        .hasRole("xem_thong_tin_kho")
                    .antMatchers(HttpMethod.GET,"/api/feeds/feedlist/")
                        .hasRole("xuat_cam_cho_heo_an")
                    .antMatchers(HttpMethod.GET,"//api/feeds/feedlist/")
                        .hasRole("xem_lich_su_xuat_cam")
                //quan_ly_danh_sach_chung_tu
                    .antMatchers(HttpMethod.GET,"/api/invoices/list")
                        .hasRole("xem_danh_sach_chung_tu")
                    .antMatchers(HttpMethod.POST,"/api/invoicespig/")
                        .hasRole("them_chung_tu_nhap_heo_trong_he_thong")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicespig/")
                        .hasRole("xoa_chung_tu_nhap_heo_trong_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasRole("cap_nhat_chung_tu_nhap_heo_trong_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasRole("xac_nhan_hoan_tat_chung_tu_nhap_heo_trong_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasRole("danh_gia_lai_heo_thuoc_chung_tu_nhap_heo_trong_he_thong")
                    .antMatchers(HttpMethod.POST,"/api/invoicespig/")
                        .hasRole("them_chung_tu_nhap_heo_ngoai_he_thong")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicespig/")
                        .hasRole("xoa_chung_tu_nhap_heo_ngoai_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasRole("cap_nhat_chung_tu_nhap_heo_ngoai_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasRole("xac_nhan_hoan_tat_chung_tu_nhap_heo_ngoai_he_thong")
                    .antMatchers(HttpMethod.POST,"/api/invoicepigdetail/pigsinvoicepigdetail/")
                        .hasRole("them_chi_tiet_chung_tu_nhap_heo_ngoai_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasRole("danh_gia_lai_heo_thuoc_chung_tu_nhap_heo_ngoai_he_thong")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicepigdetail/")
                        .hasRole("xoa_chi_tiet_chung_tu_nhap_heo_ngoai_he_thong")
                    .antMatchers(HttpMethod.POST,"/api/invoicespig/")
                        .hasRole("them_chung_tu_xuat_heo_trong_he_thong")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicespig/")
                        .hasRole("xoa_chung_tu_xuat_heo_trong_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasRole("cap_nhat_chung_tu_xuat_heo_trong_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/invoicespig/")
                        .hasRole("xac_nhan_xuat_heo_chung_tu_xuat_heo_trong_he_thong")
                    .antMatchers(HttpMethod.POST,"/api/invoicepigdetail/pigsinvoicepigdetail/")
                        .hasRole("them_chi_tiet_chung_tu_xuat_heo_trong_he_thong")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasRole("danh_gia_lai_heo_thuoc_chung_tu_xuat_heo_trong_he_thong")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicepigdetail/onlyinvoicedetail/")
                        .hasRole("xoa_chi_tiet_chung_tu_xuat_heo_trong_he_thong")
                    .antMatchers(HttpMethod.POST,"/api/invoicesproduct/")
                        .hasRole("them_chung_nhap_cam")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicesproduct/")
                        .hasRole("xoa_chung_tu_nhap_cam")
                    .antMatchers(HttpMethod.PUT,"/api/invoicesproduct/")
                        .hasRole("cap_nhat_chung_tu_nhap_cam")
                    .antMatchers(HttpMethod.POST,"/api/foodwarehouse/")
                        .hasRole("them_chi_tiet_chung_tu_nhap_cam")
                    .antMatchers(HttpMethod.PUT,"/api/foodwarehouse/")
                        .hasRole("cap_nhat_chi_tiet_chung_tu_nhap_cam")
                    .antMatchers(HttpMethod.DELETE,"/api/foodwarehouse/")
                        .hasRole("xoa_chi_tiet_chung_tu_nhap_cam")
                    .antMatchers(HttpMethod.POST,"/api/invoicesproduct/")
                        .hasRole("them_chung_nhap_thuoc")
                    .antMatchers(HttpMethod.DELETE,"/api/invoicesproduct/")
                        .hasRole("xoa_chung_tu_nhap_thuoc")
                    .antMatchers(HttpMethod.PUT,"/api/invoicesproduct/")
                        .hasRole("cap_nhat_chung_tu_nhap_thuoc")
                    .antMatchers(HttpMethod.POST,"/api/medicinewarehouse/")
                        .hasRole("them_chi_tiet_chung_tu_nhap_thuoc")
                    .antMatchers(HttpMethod.PUT,"/api/medicinewarehouse/")
                        .hasRole("cap_nhat_chi_tiet_chung_tu_nhap_thuoc")
                    .antMatchers(HttpMethod.DELETE,"/api/medicinewarehouse/")
                        .hasRole("xoa_chi_tiet_chung_tu_nhap_thuoc")
                //quan_ly_hoat_dong
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("quan_ly_heo_khu_cach_ly")
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("quan_ly_heo_khu_noc")
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("quan_ly_heo_khu_phoi")
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("quan_ly_heo_khu_mang_thai")
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("quan_ly_heo_khu_de")
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("quan_ly_heo_khu_cai_sua")
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("quan_ly_heo_khu_hau_bi")
                    .antMatchers(HttpMethod.GET,"/api/pigs/list")
                        .hasRole("quan_ly_heo_khu_8")
                    .antMatchers(HttpMethod.GET,"/api/pigs/**")
                        .hasRole("xem_thong_tin_heo")
                    .antMatchers(HttpMethod.POST,"/api/issuespigs/")
                        .hasRole("nhap_van_de_cua_heo")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasRole("danh_gia_chuyen_noi_bo")
                    .antMatchers(HttpMethod.POST,"/api/breedings/")
                        .hasRole("len_giong_heo_nai")
                    .antMatchers(HttpMethod.PUT,"/api/breedings/")
                        .hasRole("cap_nhat_thong_tin_len_giong")
                    .antMatchers(HttpMethod.DELETE,"/api/breedings/")
                        .hasRole("xoa_thong_tin_len_giong")
                    .antMatchers(HttpMethod.GET,"/api/breedings/list")
                        .hasRole("xem_danh_sach_len_giong")
                    .antMatchers(HttpMethod.POST,"/api/sperm/")
                        .hasRole("khai_thac_tinh_heo")
                    .antMatchers(HttpMethod.PUT,"/api/sperm/")
                        .hasRole("cap_nhat_thong_tin_khai_thac_tinh_heo")
                    .antMatchers(HttpMethod.DELETE,"/api/sperm/")
                        .hasRole("xoa_thong_tin_khai_thac_tinh_heo")
                    .antMatchers(HttpMethod.GET,"/api/sperm/list")
                        .hasRole("xem_danh_sach_khai_thac_tinh_heo")
                    .antMatchers(HttpMethod.POST,"/api/matings/matingsmatingdetails/")
                        .hasRole("ghi_nhan_phoi_giong")
                    .antMatchers(HttpMethod.PUT,"/api/matings/matingsmatingdetails/")
                        .hasRole("cap_nhat_thong_tin_phoi_giong")
                    .antMatchers(HttpMethod.DELETE,"/api/matings/")
                        .hasRole("xoa_thong_tin_phoi_giong")
                    .antMatchers(HttpMethod.GET,"/api/matings/matingsmatingdetails/list")
                        .hasRole("xem_danh_sach_phoi_giong")
                    .antMatchers(HttpMethod.PUT,"/api/matings/")
                        .hasRole("xac_nhan_heo_mang_thai")
                    .antMatchers(HttpMethod.PUT,"/api/matings/")
                        .hasRole("xac_nhan_heo_say_thai")
                    .antMatchers(HttpMethod.POST,"/api/births/")
                        .hasRole("ghi_nhan_thong_tin_heo_de")
                    .antMatchers(HttpMethod.PUT,"/api/births/")
                        .hasRole("cap_nhat_thong_tin_heo_de")
                    .antMatchers(HttpMethod.DELETE,"/api/births/")
                        .hasRole("xoa_ghi_nhan_thong_tin_heo_de")
                    .antMatchers(HttpMethod.POST,"/api/invoicepigdetail/pigsinvoicepigdetail/")
                        .hasRole("nhap_heo_con")
                    .antMatchers(HttpMethod.PUT,"/api/pigs/")
                        .hasRole("them_vao_danh_sach_cai_sua")
                //quan_ly_thiet_lap
                    .antMatchers(HttpMethod.GET,"/api/settings/list")
                        .hasRole("xem_danh_sach_thiet_lap")
                    .antMatchers(HttpMethod.GET,"/api/settings/list")
                        .hasRole("thiet_lap_trang_thai_mang_thai")
                    .antMatchers("/api/breeds/**")
                        .hasRole("thiet_lap_danh_sach_giong")
                    .antMatchers("/api/breedingtype/**")
                        .hasRole("thiet_lap_loai_len_giong")
                    .antMatchers("/api/healthstatus/**")
                        .hasRole("thiet_lap_trang_thai_suc_khoe")
                    .antMatchers("/api/diseases/**")
                        .hasRole("thiet_lap_danh_sach_benh")
                    .antMatchers("/api/farmtypes/**")
                        .hasRole("thiet_lap_danh_sach_loai_trang_trai")
                    .antMatchers("/api/foodtype/**")
                        .hasRole("thiet_lap_danh_sach_loai_thuc_an")
                    .antMatchers("/api/foodunits/**")
                        .hasRole("thiet_lap_don_vi_cam")
                    .antMatchers("/api/foods/**")
                        .hasRole("thiet_lap_danh_sach_cam")
                    .antMatchers("/api/medicinetype/**")
                        .hasRole("thiet_lap_nhom_thuoc")
                    .antMatchers("/api/medicines/**")
                        .hasRole("thiet_lap_danh_sach_thuoc")
                    .antMatchers(HttpMethod.GET,"/api/settings/list")
                        .hasRole("thiet_lap_danh_sach_ma_san_pham")
                    .antMatchers("/api/foottype/**")
                        .hasRole("thiet_lap_loai_chan")
                    .antMatchers("/api/gentialtype/**")
                        .hasRole("thiet_lap_loai_bo_phan_sinh_duc")
                    .antMatchers("/api/status/**")
                        .hasRole("thiet_lap_danh_sach_trang_thai_heo")
                    //Note
                    .antMatchers("/api/rounds/**")
                        .hasRole("thiet_lap_danh_sach_lua")
                    .antMatchers(HttpMethod.GET,"/api/settings/list")
                        .hasRole("thiet_lap_danh_sach_chuc_vu")
                    .antMatchers("/api/matingroles/**")
                        .hasRole("thiet_lap_luat_phoi")
                    .antMatchers("/api/**","/auth/check_login")
                        .hasAnyRole("admin")
                    .anyRequest()
                        .hasAnyRole("ADMIN","USER");

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}