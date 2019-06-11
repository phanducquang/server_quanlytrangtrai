package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.model.Schedule;
import tk.giaiphapchannuoi.server.repository.EmployeesRepository;
import tk.giaiphapchannuoi.server.repository.ScheduleRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public Boolean sendEmailNotification(String email, Integer scheduleId) throws MailException, MessagingException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(mail, multipart, "UTF-8");
        Optional<Employees> employee = employeesRepository.findByEmailAndDelFlag(email,false);
        Optional<Schedule> schedule = scheduleRepository.findByIdAndDelFlag(scheduleId,false);
        if (employee.isPresent() && schedule.isPresent()){
            String htmlMsg = "Chào <strong>" + employee.get().getName() + "</strong>,<br/>Bạn có một công việc mới vừa được phân công.<br/>"
                    + "<strong>Tên công việc: </strong>" + schedule.get().getName() + "<br/>"
                    + "<strong>Ngày thực hiện: </strong>" + schedule.get().getDate() + "<br/>";
            mail.setContent(htmlMsg,"text/html; charset=utf-8");
            mail.setFrom("${spring.mail.username}");
            helper.addTo(email);
            helper.setSubject("Thông Báo Phân Công Công Việc");
            javaMailSender.send(mail);
            return true;
        }
       return false;
    }
}
