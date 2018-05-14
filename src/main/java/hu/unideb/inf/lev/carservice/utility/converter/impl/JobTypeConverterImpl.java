package hu.unideb.inf.lev.carservice.utility.converter.impl;

import hu.unideb.inf.lev.carservice.model.JobType;
import hu.unideb.inf.lev.carservice.utility.converter.JobTypeConverter;
import hu.unideb.inf.lev.carservice.viewmodel.JobTypeViewModel;
import hu.unideb.inf.lev.carservice.viewmodel.SelectableJobTypeViewModel;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class JobTypeConverterImpl implements JobTypeConverter {
    @Override
    public JobTypeViewModel fromModel(JobType model) {
        return new JobTypeViewModel(
                model.getId(),
                new SimpleStringProperty(model.getName()),
                new SimpleLongProperty(model.getPrice())
        );
    }

    @Override
    public JobType toModel(JobTypeViewModel viewModel) {
        return new JobType(
                viewModel.getId(),
                viewModel.getName(),
                viewModel.getPrice()
        );
    }
}
