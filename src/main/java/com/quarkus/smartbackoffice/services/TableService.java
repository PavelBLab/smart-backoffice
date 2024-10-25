package com.quarkus.smartbackoffice.services;

import com.quarkus.smartbackoffice.exceptions.ResourceNotFoundException;
import com.quarkus.smartbackoffice.mappers.TableMapper;
import com.quarkus.smartbackoffice.persistence.repository.TableRepository;
import com.quarkus.smartbackoffice.provider.models.TableDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
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
        val table = tableRepository.findByIdOptional(tableId);

        if (table.isPresent()) {
            return tableMapper.mapToTableDto(table.get());
        } else {
            throw new ResourceNotFoundException("Table with tableId: " + tableId + " is not found");
        }
    }

    @Transactional
    public TableDto createTable(final TableDto tableDto) {
        tableRepository.persist(tableMapper.mapToTable(tableDto));
        return tableDto;
    }


    @Transactional
    public void deleteTable(final Long tableId) {
        val table = tableRepository.findByIdOptional(tableId);
        if (table.isEmpty()) {
            throw new NotFoundException("Table with tableId: " + tableId + " is not found");
        }
        tableRepository.deleteById(tableId);
    }

}
 