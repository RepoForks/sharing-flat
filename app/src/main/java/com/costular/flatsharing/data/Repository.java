package com.costular.flatsharing.data;

/**
 * Created by diego on 12/12/15.
 */
public class Repository {

    private static GroupDataSource dataCached;
    private static EconomyDataSource economyCached;

    public synchronized static GroupDataSource getInMemoryRepoInstance(GroupsApiService apiService) {
        if(dataCached == null) {
            dataCached = new GroupDataCached(apiService);
        }
        return dataCached;
    }

    public synchronized static EconomyDataSource getInMemoryRepoEconomyInstance(
            EconomyApiService economyApiService) {
        if(economyCached == null) {
            economyCached = new EconomyDataCached(economyApiService);
        }
        return economyCached;
    }
}
