package com.ismailadi.techicaltestbackend;

import com.ismailadi.techicaltestbackend.model.DivisionsModel;
import com.ismailadi.techicaltestbackend.model.EmployeesModel;
import com.ismailadi.techicaltestbackend.repository.DivisionRepository;
import com.ismailadi.techicaltestbackend.repository.EmployeesRepositories;
import com.ismailadi.techicaltestbackend.repository.PositionRepository;
import com.ismailadi.techicaltestbackend.model.PositionsModel;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeesBackendApplication {

    private String[] DIVISIONS = {"IT", "HRD", "Loading", "Ticketing"};
    private String[] POSITIONS = {"Staff", "Supervisor", "Asisten Manager", "Manager"};
    private String[] EMPLOYEES = {"John", "Doe", "Matt", "Lisa", "Smith", "Edd", "Leal", "Jack", "Lucy", "Jessica", "Will", "Leo", "Mose", "Misa", "Ali", "Son"};

    public static void main(String[] args) {
        SpringApplication.run(EmployeesBackendApplication.class, args);
    }

    @Bean
    ApplicationRunner initial(EmployeesRepositories employeeRepository, DivisionRepository divisionRepository, PositionRepository positionRepository) {
        return args -> {
            AtomicInteger employeeIncrementId = new AtomicInteger(1);
            AtomicInteger positionIncrementId = new AtomicInteger(1);
            Stream<String> divisionList = Arrays.stream(this.DIVISIONS);
            Stream<String> positionList = Arrays.stream(this.POSITIONS);
            Stream<String> employeeList = Arrays.stream(this.EMPLOYEES);

            divisionList.forEach(name -> {
                DivisionsModel division = new DivisionsModel();
                division.setName(name);
                divisionRepository.save(division);
            });

            positionList.forEach(name -> {
                PositionsModel position = new PositionsModel();
                position.setName(name);
                position.setLevel(positionIncrementId.intValue());
                positionIncrementId.addAndGet(1);
                positionRepository.save(position);
            });

            employeeList.forEach(name -> {
                EmployeesModel employees = new EmployeesModel();
                int divisionId = createRandomNumber(1, 4);
                int positionId = createRandomNumber(1, 4);
                int lastPositionId = createRandomNumber(0, 3);

                employees.setId(employeeIncrementId.longValue());
                employees.setName(name);
                employees.setType("PROMOTION");
                employees.setNik("EM0000"+employeeIncrementId.intValue());
                employees.setDivisionId(divisionId);
                employees.setPositionId(positionId);
                employees.setLastPosition(this.POSITIONS[lastPositionId]);
                employeeIncrementId.addAndGet(1);
                employeeRepository.save(employees);
            });
        };
    }

    private int createRandomNumber(int min, int max){
        int range = max - min + 1;
        int randomNumber = (int)(Math.random() * range) + min;
        return randomNumber;
    }

}
