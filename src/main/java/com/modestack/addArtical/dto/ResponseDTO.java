package com.modestack.addArtical.dto;

import java.util.Collection;

public interface ResponseDTO<T> {

int getCode();

void setCode(int code);

Collection getMessage();

void setMessage(Collection message);

T getData();

void setData(T data);
}
