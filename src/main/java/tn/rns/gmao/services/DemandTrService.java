package tn.rns.gmao.services;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.rns.gmao.exeption.BadRequestException;
import tn.rns.gmao.exeption.NotFoundException;
import tn.rns.gmao.model.DemandeTraveau;
import tn.rns.gmao.repository.DemandeTraveauRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class DemandTrService {

    private final DemandeTraveauRepo studentRepository;

    public List<DemandeTraveau> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(DemandeTraveau student) throws BadRequestException {
        Boolean emailExists = studentRepository.existsByEmail(student.getEmail());
        if (emailExists) {
            throw new BadRequestException(String.format(
                    "Email `%s` already exist",
                    student.getEmail()
            ));
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new NotFoundException(String.format(
                    "Student with id %s does not exists",
                    studentId
            ));
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(DemandeTraveau student) {
        studentRepository.save(student);
    }
}
