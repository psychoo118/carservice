package hu.unideb.inf.lev.carservice.utility.converter.impl;

import hu.unideb.inf.lev.carservice.model.JobType;
import hu.unideb.inf.lev.carservice.utility.converter.JobTypeConverter;
import hu.unideb.inf.lev.carservice.viewmodel.JobTypeViewModel;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * A converter class which manages the conversions between {@link JobType} entities
 * and {@link JobTypeViewModel} view models.
 */
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
