package HeapPQ;

import java.util.*;

class Tweet implements Comparable<Tweet>{
    int tweetId;
    int time;

    public Tweet(int tweetId, int time){
        this.tweetId = tweetId;
        this.time = time;
    }

    @Override
    public int compareTo(Tweet o) {
        return this.time - o.time;
    }
}

public class Twitter {
    HashMap<Integer, List<Tweet>> tweets;
    HashMap<Integer, HashSet<Integer>> following;
    int time;
    public Twitter() {
        this.tweets = new HashMap<>();
        time = 0;
        this.following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!this.tweets.containsKey(userId)) this.tweets.put(userId, new ArrayList<>());
        this.tweets.get(userId).add(new Tweet(tweetId, ++time));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> feeds = new ArrayList<>();

        if(this.tweets.containsKey(userId)) feeds.addAll(this.tweets.get(userId));

        if(this.following.containsKey(userId)){
            for(Integer f : this.following.get(userId)) {
                if(this.tweets.containsKey(f)){
                    feeds.addAll(this.tweets.get(f));
                }
            }
        }

        PriorityQueue<Tweet> minHeap = new PriorityQueue<>();
        for(Tweet t : feeds){
            minHeap.add(t);
            if(minHeap.size() > 10) minHeap.poll();
        }
        List<Integer> newsFeed = new ArrayList<>();
        while(!minHeap.isEmpty()) newsFeed.add(0, minHeap.poll().tweetId);
        System.out.println(newsFeed);
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(!this.following.containsKey(followerId)) this.following.put(followerId, new HashSet<>());
        this.following.get(followerId).add(followeeId);
//        System.out.println(this.following.get(followerId));
    }

    public void unfollow(int followerId, int followeeId) {
        if(this.following.containsKey(followerId)) {
            this.following.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }
}
