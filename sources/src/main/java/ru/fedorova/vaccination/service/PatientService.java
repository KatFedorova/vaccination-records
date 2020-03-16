package ru.fedorova.vaccination.service;

import com.mysql.cj.protocol.Message;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.fedorova.vaccination.model.dto.PatientDTO;
import ru.fedorova.vaccination.model.entity.Patient;
import ru.fedorova.vaccination.repo.PatientRepository;
/**
 * Сервис-класс для манипуляций с Пациентами
 *
 */
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;


    /**
     * Конвертирует объект patientDTO в Patient (парсит все поля)
     * @param patientDTO
     * @return Patient
     */
    public Patient patDtoToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();

            Long snils = Long.parseLong(patientDTO.getSnils());
            patient.setSnils(snils);

            String name = patientDTO.getName();
            patient.setName(name);

            String surname = patientDTO.getSurname();
            patient.setSurname(surname);

            String patronymic = patientDTO.getPatronymic();
            patient.setPatronymic(patronymic);

            Date birthDate = Date.valueOf(patientDTO.getBirthDate());
            patient.setBirthDate(birthDate);

            Integer medicalInstitutionCode = Integer.parseInt(patientDTO.getMedicalInstitutionCode());
            patient.setMedicalInstitutionCode(medicalInstitutionCode);

        return patient;
    }

    /**
     * Принимает обект patientDTO, конвертирует в Patient и сохраняет в БД
     * @param patientDTO
     */
    public void savePatient(PatientDTO patientDTO) {
        patientDTO.setMedicalInstitutionCode("720001");
        Patient patient = patDtoToEntity(patientDTO);
        try {
            patientRepository.save(patient);
        } catch (DataIntegrityViolationException e) {
            System.err.println("Ошибка записи пациента в БД");
            System.err.println(patientDTO.toString());
            System.err.println(e.getMostSpecificCause());
        }
    }
}
