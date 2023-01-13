package com.example.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.models.Cutoff;
import com.example.restservice.models.CutoffCurrencyPairResponse;
import com.example.restservice.repositories.CutoffRepository;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="/api/v1/currency/cutoffs")
public class CutoffController {
    @Autowired
    private CutoffRepository cutoffRepository;

	@GetMapping("/pair")
	public CutoffCurrencyPairResponse greeting(
        @RequestParam(value = "currencyA") String currencyA,
        @RequestParam(value = "currencyB") String currencyB
        // @RequestParam(value = "targetDate") String targetDate  // TODO: Not implemented
    ) {

        // TODO: Not sure how to implement date-selection (e.g. findByIsoAndByDate, excluding HH:MM:SS)
        Cutoff cutoffA = cutoffRepository.findByIso(currencyA);
        Cutoff cutoffB = cutoffRepository.findByIso(currencyB);

        // Check if either ISO is not found
        if (cutoffA == null || cutoffB == null) {
            // Don't know why this didn't work
            // https://stackoverflow.com/a/2067043/3717691
        }

        // Handle the never case (return null?)
        if (cutoffA.isNeverPossible() || cutoffB.isNeverPossible()) {
            return new CutoffCurrencyPairResponse(null);
        }

        // Return the earliest cutoff
		return new CutoffCurrencyPairResponse(cutoffA.getDate().before(cutoffB.getDate()) ? cutoffA.getDate() : cutoffB.getDate());
	}
}