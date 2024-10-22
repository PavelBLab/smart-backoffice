package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.persistence.entity.Table;
import com.quarkus.smartbackoffice.provider.controllers.TablesApi;
import com.quarkus.smartbackoffice.provider.models.GeneratedTable;
import com.quarkus.smartbackoffice.services.TableService;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
// @NonBlocking
public class TablesController implements TablesApi {

    @Inject
    private final TableService tableService;

    @Override
    public Response allTables() {
        return Response.ok(List.of(tableService.tablesGet())).build();
    }

    @Override
    public Response createTable(final GeneratedTable generatedTable) {
        val table = Table.builder()
                .name(generatedTable.getName())
                .seatCount(generatedTable.getSeatCount())
                .active(generatedTable.getActive())
                .build();
        val persistedTable = tableService.persist(table);

        return Response.created(URI.create("/tables/" + persistedTable.getId())).build();
    }

    @Override
    public Response deleteTable(final Long tableId) {
        return Response.ok().build();}


    @Override
    public Response oneTable(final Long tableId) {
        return Response.ok(tableService.tablesGet()).build();
    }

    @Override
    public Response updateTable(final Long tableId, final GeneratedTable table) {
        return Response.ok().build();
    }
}
