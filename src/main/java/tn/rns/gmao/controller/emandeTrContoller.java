package tn.rns.gmao.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.exeption.BadRequestException;
import tn.rns.gmao.model.DemandeTraveau;
import tn.rns.gmao.services.DemandTrService;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/students")
@CrossOrigin("*")
public class emandeTrContoller {

    private final DemandTrService studentService;

    @GetMapping
    public List<DemandeTraveau> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody DemandeTraveau student) throws BadRequestException {
        studentService.addStudent(student);
    }

    @PutMapping
    public void updateStudent(@Valid @RequestBody DemandeTraveau student) throws BadRequestException {
        studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
