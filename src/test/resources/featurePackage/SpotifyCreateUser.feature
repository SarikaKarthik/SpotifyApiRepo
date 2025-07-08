Feature: Validate Create PlayList
Scenario:To validate user is able to create the PlayList
Given required payload and endpoints to create the playlist
When User creates the playlist 
Then User should get the status code as 201