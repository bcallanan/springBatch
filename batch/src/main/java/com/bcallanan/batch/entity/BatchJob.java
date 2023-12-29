package com.bcallanan.batch.entity;

import jakarta.validation.constraints.NotNull;

public record BatchJob(@NotNull String name) {
}
