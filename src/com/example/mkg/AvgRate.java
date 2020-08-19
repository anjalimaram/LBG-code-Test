package com.example.mkg;

import com.example.data.CreditData;
import com.example.data.Key;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvgRate implements Lag<Key, Double, CreditData> {


    @Override
    public Map<GroupingKey, Double> compute(List<CreditData> creditDataList) {
        return creditDataList.stream().collect(Collectors.groupingBy(CreditData.groupCreditDataBy,
                Collectors.averagingDouble(CreditData::getAmountInEuros)));

    }
}
