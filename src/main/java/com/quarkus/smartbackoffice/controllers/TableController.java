package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.TablesApi;
import com.quarkus.smartbackoffice.provider.models.TableDto;
import com.quarkus.smartbackoffice.services.TableService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
// @NonBlocking
public class TableController implements TablesApi {

    private final TableService tableService;

    @Override
    public Response allTables() {
        return Response.ok(List.of(tableService.allTables())).build();
    }

    @Override
    public Response oneTable(final Long tableId) {
        return Response.ok(tableService.oneTable(tableId)).build();
    }

    @Override
    public Response createTable(final TableDto tableDto) {
        val persistedTable = tableService.createTable(tableDto);
        return Response.created(URI.create("/tables/" + persistedTable.getId())).build();
    }

    @Override
    public Response updateTable(final Long tableId, final TableDto tableDto) {
        return Response.ok().build();
    }

    @Override
    public Response deleteTable(final Long tableId) {
        return Response.ok().build();
    }

}
