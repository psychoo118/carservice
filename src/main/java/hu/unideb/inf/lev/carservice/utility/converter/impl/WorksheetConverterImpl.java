package hu.unideb.inf.lev.carservice.utility.converter.impl;

import hu.unideb.inf.lev.carservice.model.Worksheet;
import hu.unideb.inf.lev.carservice.utility.converter.ConverterHelper;
import hu.unideb.inf.lev.carservice.utility.converter.WorksheetConverter;
import hu.unideb.inf.lev.carservice.viewmodel.CarViewModel;
import hu.unideb.inf.lev.carservice.viewmodel.JobTypeViewModel;
import hu.unideb.inf.lev.carservice.viewmodel.WorksheetViewModel;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.stream.Collectors;

/**
 * A converter class which manages the conversions between {@link Worksheet} entities
 * and {@link WorksheetViewModel} view models.
 */
public class WorksheetConverterImpl implements WorksheetConverter {
    @Override
    public WorksheetViewModel fromModel(Worksheet model) {
        return new WorksheetViewModel(
                model.getId(),
                new SimpleObjectProperty<CarViewModel>(ConverterHelper.fromModel(model.getCar())),
                new SimpleListProperty<JobTypeViewModel>(
                        FXCollections.observableArrayList(
                                model.getJobs().stream()
                                        .map(m -> ConverterHelper.fromModel(m))
                                        .collect(Collectors.toList())
                        )
                ),
                new SimpleLongProperty(model.getTotal()),
                new SimpleIntegerProperty(model.getDiscount())
        );
    }

    @Override
    public Worksheet toModel(WorksheetViewModel viewModel) {
        return new Worksheet(
                viewModel.getId(),
                ConverterHelper.toModel(viewModel.getCar()),
                viewModel.getJobs().stream().map(vm -> ConverterHelper.toModel(vm)).collect(Collectors.toList()),
                viewModel.getTotal(),
                viewModel.getDiscount()
        );
    }
}
