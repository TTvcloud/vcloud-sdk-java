package com.bytedanceapi.model.beans;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionsSnapshotInput {
    @JSONField(name = "SnapshotTime")
    double snapshotTime;
}