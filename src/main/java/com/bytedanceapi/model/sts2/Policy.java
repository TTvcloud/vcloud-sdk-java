package com.bytedanceapi.model.sts2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Policy {
    private List<Statement> statements = new ArrayList<>();

    public void addStatement(Statement statement){
        statements.add(statement);
    }
}
