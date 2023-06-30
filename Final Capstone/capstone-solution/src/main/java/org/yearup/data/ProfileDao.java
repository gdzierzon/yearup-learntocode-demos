package org.yearup.data;


import org.yearup.models.Profile;

public interface ProfileDao
{
    Profile getByUserId(int userId);
    Profile create(Profile profile);
    void update(int userId, Profile profile);
    void delete(int userId);
}
