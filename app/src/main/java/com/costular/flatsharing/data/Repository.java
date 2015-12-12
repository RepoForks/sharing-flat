package com.costular.flatsharing.data;

/**
 * Created by diego on 12/12/15.
 */
public class Repository {

    private static GroupDataSource dataCached;

    public synchronized static GroupDataSource getInMemoryRepoInstance(GroupsApiService apiService) {
        if(dataCached == null) {
            dataCached = new GroupDataCached(apiService);
        }

        return dataCached;
    }
}
