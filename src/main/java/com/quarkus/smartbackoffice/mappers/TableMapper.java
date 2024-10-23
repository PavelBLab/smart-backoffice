package com.quarkus.smartbackoffice.mappers;

import com.quarkus.smartbackoffice.persistence.entity.Table;
import com.quarkus.smartbackoffice.provider.models.TableDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TableMapper {

    @IterableMapping(qualifiedByName = "mapToTableDto")
    List<TableDto> mapToTableDtos(final List<Table> tables);

    @Named("mapToTableDto")
    TableDto mapToTableDto(final Table table);

    @IterableMapping(qualifiedByName = "mapToTable")
    List<Table> mapToTables(final List<TableDto> tableDtos);

    @Named("mapToTable")
    Table mapToTable(final TableDto tableDto);

}
