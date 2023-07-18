package com.productDetails.productRelations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonProductStatisticsService {

    @Autowired
    private CommonProductStatisticsRepo commonProductStatisticsRepo;

    public void increaseSalesStatistics(Integer productIdA, Integer productIdB) {
        CommonProductStatistics commonStats = commonProductStatisticsRepo.findByProductIdA(productIdA).orElse(null);
        if(commonStats == null) {
            CommonProductStatistics newCommonStats = new CommonProductStatistics(productIdA, productIdB, 0, 0);
            commonProductStatisticsRepo.save(newCommonStats);
        } else {
            commonStats.setCommonSales(commonStats.getCommonSales() + 1);
            commonProductStatisticsRepo.save(commonStats);
        }
    }

    public void increaseImpressionsStatistics(Integer productIdA, Integer productIdB) {
        CommonProductStatistics commonStats = commonProductStatisticsRepo.findByProductIdA(productIdA).orElse(null);
        if(commonStats == null) {
            CommonProductStatistics newCommonStats = new CommonProductStatistics(productIdA, productIdB, 0, 0);
            commonProductStatisticsRepo.save(newCommonStats);
        } else {
            commonStats.setCommonImpressions(commonStats.getCommonImpressions() + 1);
            commonProductStatisticsRepo.save(commonStats);
        }
    }

}
