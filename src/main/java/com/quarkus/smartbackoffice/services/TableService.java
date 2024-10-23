package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.mappers.TableMapper;
import com.quarkus.smartbackoffice.persistence.repository.TableRepository;
import com.quarkus.smartbackoffice.provider.models.TableDto;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;
    private final TableMapper tableMapper;

    public List<TableDto> allTables() {
        return tableMapper.mapToTableDtos(tableRepository.listAll());
    }

    public TableDto oneTable(final Long tableId) {
        val table = tableRepository.getById(tableId);

        if (table.isPresent()) {
            return tableMapper.mapToTableDto(table.get());
        } else {
            return TableDto.builder().build();
        }
    }

    public TableDto createTable(final TableDto tableDto) {
        val persistedTable = tableRepository.persist(tableMapper.mapToTable(tableDto));
        return tableMapper.mapToTableDto(persistedTable);
    }

}
