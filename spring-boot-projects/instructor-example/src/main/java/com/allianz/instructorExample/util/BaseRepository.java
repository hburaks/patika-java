package com.allianz.instructorExample.util;

import com.allianz.instructorExample.util.dbutil.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {


}