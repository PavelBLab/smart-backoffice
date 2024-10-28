package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.TablesApi;
import com.quarkus.smartbackoffice.provider.models.TableDto;
import com.quarkus.smartbackoffice.services.TableService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Blocking
@Path("/tables")
@Tag(name = "Tables", description = "Endpoints related to managing tables")
@RolesAllowed("admin")
public class TableController implements TablesApi {

    private final TableService tableService;

    @Override
    @Blocking
    public Response allTables() {
        log.info("Returns all tables");
        return Response.ok(List.of(tableService.allTables())).build();
    }

    @Override
    @Blocking
    public Response oneTable(final Long tableId) {
        val table = tableService.oneTable(tableId);
        log.info("Returns a table with tableId: " + table.getId());
        return Response.ok(table).build();
    }

    @Override
    @Blocking
    public Response createTable(final TableDto tableDto) {
        val persistedTable = tableService.createTable(tableDto);
        log.info("Creates a table with name: " + tableDto.getName());
        return Response.created(URI.create("/tables/" + persistedTable.getId())).build();
    }

    @Override
    @Blocking
    public Response updateTable(final Long tableId, final TableDto tableDto) {
        return Response.ok().build();
    }

    @Override
    @Blocking
    public Response deleteTable(final Long tableId) {
        tableService.deleteTable(tableId);
        log.info("Deletes a table with tableId: " + tableId);
        return Response.noContent().build();
    }

}
