package com.sbmongodbexp.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sbmongodbexp.model.User;

/*
Keyword	:
And - findByLastnameAndFirstname
Or - findByLastnameOrFirstname
Is, Equals - findByFirstname,findByFirstnameIs,findByFirstnameEquals
Between-findByStartDateBetween
LessThan-findByAgeLessThan
LessThanEqual - findByAgeLessThanEqual
GreaterThan - findByAgeGreaterThan
GreaterThanEqual -findByAgeGreaterThanEqual
After - findByStartDateAfter
Before - findByStartDateBefore
IsNull, Null - findByAge(Is)Null
IsNotNull, NotNull -findByAge(Is)NotNull
Like - findByFirstnameLike
NotLike - findByFirstnameNotLike
StartingWith - findByFirstnameStartingWith
EndingWith -findByFirstnameEndingWith
Containing -findByFirstnameContaining
OrderBy - findByAgeOrderByLastnameDesc
Not - findByLastnameNot
In - findByAgeIn(Collection<Age> ages)
NotIn -findByAgeNotIn(Collection<Age> ages)
True - findByActiveTrue()
False - findByActiveFalse()
IgnoreCase -findByFirstnameIgnoreCase
*/

public interface UserRepository extends MongoRepository<User, Integer> {

	List<User> findByUserName(String userName);
	List<User> findByUserNameIsAndTeamName(String userName,String teamName);
	List<User> findByUserNameOrTeamName(String userName,String teamName);
	List<User> findByUserIdBetween(int firstValue ,int secoondValue);
	List<User> findByUserIdLessThan(int userId);
	
	//@Query("{'population' : {$gt : ?0, $lt : ?1}}")
	// @Query("{'continent.name' : ?0, population : {$lt : ?1}}")
	//@Query(value="{'continent.name' : ?0}", fields="{_id : 0, name : 1}")
	//@Query("{'$or' : [{'population' : {$lt : ?0}}, {'area' : {$lt : ?1}}]}")
	@Query("{address : {$ne : ?0}}")
	List<User> findByAddress(String address);
	
}
