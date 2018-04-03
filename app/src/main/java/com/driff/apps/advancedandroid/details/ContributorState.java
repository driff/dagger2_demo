package com.driff.apps.advancedandroid.details;


import com.driff.apps.advancedandroid.model.Contributor;
import com.google.auto.value.AutoValue;

import java.util.List;

import javax.annotation.Nullable;

@AutoValue
abstract class ContributorState {

    abstract boolean loading();

    @Nullable
    abstract List<Contributor> contributors();

    @Nullable
    abstract Integer errorRes();

    static Builder builder(){
        return new AutoValue_ContributorState.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder{

        abstract Builder loading(boolean loading);

        abstract Builder contributors(List<Contributor> contributors);

        abstract Builder errorRes(Integer errorRes);

        abstract ContributorState build();

    }

}
