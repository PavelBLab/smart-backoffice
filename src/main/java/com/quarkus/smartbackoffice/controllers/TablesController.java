package com.quarkus.smartbackoffice.controllers;

import com.quarkus.smartbackoffice.provider.controllers.TablesApi;
import com.quarkus.smartbackoffice.provider.models.Table;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@NonBlocking
public class TablesController implements TablesApi {

    private final Table table = Table.builder().number(1).build();

    @Override
    public Response tablesGet() {
        return Response.ok(List.of(table)).build();
    }

    @Override
    public Response tablesPost(final Table table) {
        return Response.created(URI.create("todo")).build();
    }

    @Override
    public Response tablesTableIdDelete(final String tableId) {
        return Response.ok().build();
    }

    @Override
    public Response tablesTableIdGet(final String tableId) {
        return Response.ok(table).build();
    }

    @Override
    public Response tablesTableIdPut(final String tableId, final Table table) {
        return Response.ok().build();
    }
}
