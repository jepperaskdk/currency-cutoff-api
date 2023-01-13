package com.example.restservice.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.restservice.models.Cutoff;
import com.example.restservice.repositories.CutoffRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CutoffSeeder implements CommandLineRunner {
    @Autowired
	CutoffRepository cutoffRepository;

    @Override
	public void run(String... args) throws Exception {
		seedCutoffs();
	}

    private void seedCutoffs() {
		if (cutoffRepository.count() == 0) {
            cutoffRepository.save(new Cutoff("DKK", "Denmark", getDate(2022, 0, 13, 15, 30, 00)));
            cutoffRepository.save(new Cutoff("EUR", "Euro Area", getDate(2022, 0, 13, 16, 00, 00)));
            cutoffRepository.save(new Cutoff("AED", "United Arab Emirates", getDate(2022, 0, 13, 00, 00, 00)));
		}
	}

    private Date getDate(int year, int month, int day, int hour, int minute, int second) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
        } catch (ParseException e) {
            return null;
        }
    }
}
