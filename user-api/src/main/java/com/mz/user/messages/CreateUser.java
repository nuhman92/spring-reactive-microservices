package com.mz.user.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mz.reactivedemo.common.api.events.Command;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * Created by zemi on 13/01/2019.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableCreateUser.class)
@JsonDeserialize(as = ImmutableCreateUser.class)
public interface CreateUser extends Command {

  String firstName();

  String lastName();

  Optional<CreateContactInfo> contactInformation();

  static ImmutableCreateUser.Builder builder() {
    return ImmutableCreateUser.builder();
  }
}