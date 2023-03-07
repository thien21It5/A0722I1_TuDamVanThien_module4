package codegym.service;

import org.springframework.stereotype.Service;

@Service
public class calculatorServiceImpl implements calculatorService{
    @Override
    public double tranfer(double money, double index) {
        return money * index;
    }
}
