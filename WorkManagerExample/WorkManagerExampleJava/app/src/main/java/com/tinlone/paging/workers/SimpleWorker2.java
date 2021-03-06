package com.tinlone.paging.workers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.tinlone.paging.Utils;

public class SimpleWorker2 extends Worker {


    public SimpleWorker2(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Utils.log("doWork: " + getClass().getSimpleName());
        return Result.success();
    }
}
