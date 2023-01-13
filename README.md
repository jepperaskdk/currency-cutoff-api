# Cutoff time API
Disclaimer: This is my first Java web project ever.
For this reason, I chose to not support some of the requirements:
- The specific date to get the cutoff for
- Only included a couple of currencies for simplicity (DKK, EUR, AED)

See the src/main/java/com/example/restservice folder for the relevant classes.

## Cutoff.java
Model object - I chose to implement the "never/always possible" using the date for simplicity.

## CutoffRepository.java
Was pleased to see that Spring can autogenerate repository methods from name/signature. Haven't seen that before.
I wasn't able to implement querying by the year-month-day part of the date.

## CutoffSeeder.java
Seeds the data for this example.

## CutoffCurrencyPairResponse.java
To avoid coupling my API with my underlying Model, I introduce a DTO for the API contract.
Should ideally live in a separate folder.

## CutoffController.java
For the "never possible" case, I return an object with cutoffDate set to null.
This could as well just be the date with 00:00:00, but I think that is less intuitive.

## Test examples:
(Not sure why the date is returned as UTC)
GET: http://localhost:8080/api/v1/currency/cutoffs/pair?currencyA=DKK&currencyB=EUR
{"cutoffDate":"2021-12-13T14:30:00.000+00:00"}

(AED is "Never possible" for this day)
GET: http://localhost:8080/api/v1/currency/cutoffs/pair?currencyA=DKK&currencyB=AED
{"cutoffDate":null}

