package mapper;

import com.acm.entity.Patient;
import com.acm.mapper.PatientMapper;
import org.junit.Test;

public class PatientMapperTests {

    @Test
    public   void updateInfoByRealname(){
        Patient patient=new Patient();
        patient.setRealname("王倩文");
        patient.setPhonenumber("1234234456");
        patient.setEmail("teskta@qq.com");

    }
}
