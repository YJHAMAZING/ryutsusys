package com.wetech.core.service;

import com.wetech.ryutsumodel.model.dto.MicAComa014InputDto;
import com.wetech.ryutsumodel.model.dto.MicAComa014OutputDto;

public interface MicAComa014Service {
    MicAComa014OutputDto getRecord(MicAComa014InputDto micAComa014InputDto);
}
