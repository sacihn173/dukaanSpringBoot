package com.productDetails.productRelations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonProductStatisticsService {

    @Autowired
    private CommonProductStatisticsRepo commonProductStatisticsRepo;

    public void increaseSalesStatistics(Integer productIdA, Integer productIdB) {
        CommonProductStatistics commonStats = commonProductStatisticsRepo.findByProductIdAAndProductIdB(productIdA, productIdB);
        if(commonStats == null) {
            CommonProductStatistics newCommonStats = new CommonProductStatistics(productIdA, productIdB, 0, 0);
            commonProductStatisticsRepo.save(newCommonStats);
        } else {
            commonStats.setCommonSales(commonStats.getCommonSales() + 1);
            commonProductStatisticsRepo.save(commonStats);
        }
    }

    public void increaseImpressionsStatistics(Integer productIdA, Integer productIdB) {
        CommonProductStatistics commonStats = commonProductStatisticsRepo.findByProductIdAAndProductIdB(productIdA, productIdB);
        if(commonStats == null) {
            CommonProductStatistics newCommonStats = new CommonProductStatistics(productIdA, productIdB, 0, 0);
            commonProductStatisticsRepo.save(newCommonStats);
        } else {
            commonStats.setCommonImpressions(commonStats.getCommonImpressions() + 1);
            commonProductStatisticsRepo.save(commonStats);
        }
    }

    /**
     * Get products related to product ordered by ordered by sales and impressions
     */
    public List<CommonProductStatistics> findByProductIdAOrderedBySalesAndImpressions(Integer productAId) {
        return commonProductStatisticsRepo.findByProductIdAOrderedBySalesAndImpressions(productAId);
    }

}
