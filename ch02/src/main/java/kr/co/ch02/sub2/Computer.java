package kr.co.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {

    // 필드 주입 (권장되지 않음)
    @Autowired
    private CPU cpu;

    // 생성자 주입 (권장, final 속성)
    @Autowired
    private final RAM ram;

    public Computer(RAM ram) {
        this.ram = ram;
    }

    // 세터 주입
    private HDD hdd;

    @Autowired
    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public void show(){
        cpu.show();
        ram.show();
        hdd.show();
    }
}
