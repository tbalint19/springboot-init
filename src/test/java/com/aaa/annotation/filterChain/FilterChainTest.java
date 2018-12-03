package com.aaa.annotation.filterChain;

import com.aaa.annotation.UnAuthenticatedUser;
import com.aaa.model.dto.GroupData;
import com.aaa.model.entity.Session;
import com.aaa.model.entity.UserAuthInterface;
import com.aaa.model.exception.HTTP401;
import com.aaa.model.exception.HTTP403;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FilterChainTest {

    private static final String DO_DOMAIN_STUFF = "DoDomainStuff";
    private static final String DO_OTHER_DOMAIN_STUFF = "DoOtherDomainStuff";
    private static final String DO_GROUP_STUFF = "DoGroupStuff";
    private static final String DO_OTHER_GROUP_STUFF = "DoOtherGroupStuff";
    private static final Long GROUP_1_ID = 1L;
    private static final Long GROUP_2_ID = 2L;
    private static final List<String> NO_DOMAIN_PERMISSIONS = new ArrayList<>();
    private static final List<GroupData> NO_GROUP_PERMISSIONS = new ArrayList<>();

    @Test(expected = HTTP401.class)
    public void shouldThrow401WhenUserIdIsNull() throws HTTP401 {
        // given
        AuthEntity entity = new UnAuthenticatedUser();

        // when
        entity.exists();

        // then
        // » error is thrown
    }

    @Test
    public void shouldPassWhenUserIdIsNotNull() throws HTTP401 {
        // given
        AuthEntity entity = entity(
                NO_DOMAIN_PERMISSIONS,
                NO_GROUP_PERMISSIONS);

        // when
        entity.exists();

        // then
        // » error is not thrown
    }

    @Test(expected = HTTP403.class)
    public void shouldThrow403WhenOnlyDomainPermissionIsExpectedButMissing() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                NO_DOMAIN_PERMISSIONS,
                NO_GROUP_PERMISSIONS);

        // when
        entity.existsWith().domainPermission(DO_DOMAIN_STUFF);

        // then
        // » error is thrown
    }

    @Test
    public void shouldPassWhenOnlyDomainPermissionIsExpectedAndIsPresent() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                ImmutableList.of(DO_DOMAIN_STUFF),
                NO_GROUP_PERMISSIONS);

        // when
        entity.existsWith().domainPermission(DO_DOMAIN_STUFF);

        // then
        // » error is not thrown
    }

    @Test(expected = HTTP403.class)
    public void shouldThrow403WhenBothDomainAndGroupPermissionIsExpectedButOnlyDomainPermissionIsPresent() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                ImmutableList.of(),
                NO_GROUP_PERMISSIONS);

        // when
        entity.existsWith().both().domainPermission(DO_DOMAIN_STUFF).andGroupPermission(DO_GROUP_STUFF).forAnyGroup();

        // then
        // » error is thrown
    }

    @Test
    public void shouldPassWhenBothDomainAndGroupPermissionIsExpectedAndBothIsPresent() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                ImmutableList.of(DO_DOMAIN_STUFF),
                ImmutableList.of(groupData(GROUP_1_ID, ImmutableList.of(DO_GROUP_STUFF))));

        // when
        entity.existsWith().both().domainPermission(DO_DOMAIN_STUFF).andGroupPermission(DO_GROUP_STUFF).forAnyGroup();

        // then
        // » error is not thrown
    }

    @Test(expected = HTTP403.class)
    public void shouldThrow403WhenBothDomainAndGroupPermissionIsExpectedAndGroupPermissionExistsForWrongGroup() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                ImmutableList.of(DO_DOMAIN_STUFF),
                ImmutableList.of(groupData(GROUP_1_ID, ImmutableList.of(DO_GROUP_STUFF))));

        // when
        entity.existsWith().both().domainPermission(DO_DOMAIN_STUFF).andGroupPermission(DO_GROUP_STUFF).forGroup(GROUP_2_ID);

        // then
        // » error is thrown
    }

    @Test
    public void shouldPassWhenBothDomainAndGroupPermissionIsExpectedAndGroupPermissionExistsForExpectedGroup() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                ImmutableList.of(DO_DOMAIN_STUFF),
                ImmutableList.of(groupData(GROUP_1_ID, ImmutableList.of(DO_GROUP_STUFF))));

        // when
        entity.existsWith().both().domainPermission(DO_DOMAIN_STUFF).andGroupPermission(DO_GROUP_STUFF).forGroup(GROUP_1_ID);

        // then
        // » error is not thrown
    }

    @Test(expected = HTTP403.class)
    public void shouldThrow403WhenEitherDomainOrGroupPermissionIsExpectedAndNeitherExists() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                NO_DOMAIN_PERMISSIONS,
                NO_GROUP_PERMISSIONS);

        // when
        entity.existsWith().either().domainPermission(DO_DOMAIN_STUFF).orGroupPermission(DO_GROUP_STUFF).forAnyGroup();

        // then
        // » error is thrown
    }

    @Test
    public void shouldPassWhenEitherDomainOrGroupPermissionIsExpectedAndOnlyDomainPermissionExists() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                ImmutableList.of(DO_DOMAIN_STUFF),
                NO_GROUP_PERMISSIONS);

        // when
        entity.existsWith().either().domainPermission(DO_DOMAIN_STUFF).orGroupPermission(DO_GROUP_STUFF).forGroup(GROUP_1_ID);

        // then
        // » error is not thrown
    }

    @Test
    public void shouldPassWhenEitherDomainOrGroupPermissionIsExpectedAndOnlyGroupPermissionExists() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                NO_DOMAIN_PERMISSIONS,
                ImmutableList.of(groupData(GROUP_1_ID, ImmutableList.of(DO_GROUP_STUFF))));

        // when
        entity.existsWith().either().domainPermission(DO_DOMAIN_STUFF).orGroupPermission(DO_GROUP_STUFF).forGroup(GROUP_1_ID);

        // then
        // » error is not thrown
    }

    @Test
    public void shouldPassWhenEitherDomainOrGroupPermissionIsExpectedAndBothExist() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                ImmutableList.of(DO_DOMAIN_STUFF),
                ImmutableList.of(groupData(GROUP_1_ID, ImmutableList.of(DO_GROUP_STUFF))));

        // when
        entity.existsWith().either().domainPermission(DO_DOMAIN_STUFF).orGroupPermission(DO_GROUP_STUFF).forGroup(GROUP_1_ID);

        // then
        // » error is not thrown
    }

    @Test
    public void shouldPassWhenEitherDomainOrGroupPermissionIsExpectedAndBothExistEvenIfForWrongGroup() throws HTTP401, HTTP403 {
        // given
        AuthEntity entity = entity(
                ImmutableList.of(DO_DOMAIN_STUFF),
                ImmutableList.of(groupData(GROUP_1_ID, ImmutableList.of(DO_GROUP_STUFF))));

        // when
        entity.existsWith().either().domainPermission(DO_DOMAIN_STUFF).orGroupPermission(DO_GROUP_STUFF).forGroup(GROUP_2_ID);

        // then
        // » error is not thrown
    }

    private static AuthEntity entity(List<String> domainPermissions, List<GroupData> groups) {
        AuthEntity entity = new UserAuthInterface();
        ((UserAuthInterface) entity).setId(1L);

        Session session = new Session();
        session.setId("A-1");
        session.setPermissions(domainPermissions);
        session.setGroups(groups);

        entity.setSession(session);

        return entity;
    }

    private static GroupData groupData(Long id, List<String> permissions) {
        GroupData groupData = new GroupData();
        groupData.setGroupId(id);
        groupData.setPermissions(permissions);
        return groupData;
    }
}
