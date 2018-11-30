/* 
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.dueros.data.request.audioplayer.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("AudioPlayer.PlaybackStutterFinished")
public class PlaybackStutterFinishedEvent extends AudioPlayerEvent {

    private String token;
    private int offsetInMilliSeconds;
    private int stutterDurationInMilliseconds;

    /**
     * 返回一个用来构造{@code PlaybackStutterFinishedEvent}的{@code Builder}
     * 
     * @return Builder
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    public PlaybackStutterFinishedEvent(Builder builder) {
        super(builder);
        token = builder.token;
        offsetInMilliSeconds = builder.offsetInMilliSeconds;
        stutterDurationInMilliseconds = builder.stutterDurationInMilliseconds;
    }

    /**
     * 用来实现JSON序列化、反序列化的构造方法
     * 
     * @param requestId
     *            每个request会有不同的requestId
     * @param timestamp
     *            request时间，Bot结合http header一起用于做安全检查
     * @param token
     *            正在播放中的audio item的token
     * @param offsetInMilliSeconds
     *            当前的播放进度
     */
    private PlaybackStutterFinishedEvent(@JsonProperty("requestId") final String requestId,
            @JsonProperty("timestamp") final String timestamp,
            @JsonProperty("dialogRequestId") final String dialogRequestId, @JsonProperty("token") final String token,
            @JsonProperty("offsetInMilliSeconds") final int offsetInMilliSeconds,
            @JsonProperty("stutterDurationInMilliseconds") final int stutterDurationInMilliseconds) {
        super(requestId, timestamp, dialogRequestId);
        this.token = token;
        this.offsetInMilliSeconds = offsetInMilliSeconds;
        this.stutterDurationInMilliseconds = stutterDurationInMilliseconds;
    }

    public String getToken() {
        return token;
    }

    public int getOffsetInMilliSeconds() {
        return offsetInMilliSeconds;
    }

    public int getStutterDurationInMilliseconds() {
        return stutterDurationInMilliseconds;
    }

    /**
     * 用来构造{@code PlaybackStutterFinishedEvent}
     * 
     * @author tianlonglong(tianlong02@baidu.com)
     * @version V1.0
     * @since 2017年10月5日
     */
    public static final class Builder extends RequestBodyBuilder<Builder, PlaybackStutterFinishedEvent> {

        private String token;
        private int offsetInMilliSeconds;
        private int stutterDurationInMilliseconds;

        /**
         * 设置token的setter方法
         * 
         * @param token
         *            正在播放中的audio item的token
         * @return Builder 用来构造{@code PlaybackStutterFinishedEvent}
         */
        public Builder setToken(final String token) {
            this.token = token;
            return this;
        }

        /**
         * 设置offsetInMilliSeconds的setter方法
         * 
         * @param offsetInMilliSeconds
         *            当前的播放进度
         * @return Builder 用来构造{@code PlaybackStutterFinishedEvent}
         */
        public Builder setOffsetInMilliSeconds(final int offsetInMilliSeconds) {
            this.offsetInMilliSeconds = offsetInMilliSeconds;
            return this;
        }

        /**
         * 设置stutterDurationInMilliseconds的setter方法
         * 
         * @param stutterDurationInMilliseconds
         *            当前的播放进度
         * @return Builder 用来构造{@code PlaybackStutterFinishedEvent}
         */
        public Builder setStutterDurationInMilliseconds(final int stutterDurationInMilliseconds) {
            this.stutterDurationInMilliseconds = stutterDurationInMilliseconds;
            return this;
        }

        /**
         * 调用{@code PlaybackFinishedEvent}的私有构造方法构造
         * {@code PlaybackStutterFinished}
         * 
         * @see com.baidu.dueros.data.request.RequestBody.RequestBodyBuilder#build()
         */
        public PlaybackStutterFinishedEvent build() {
            return new PlaybackStutterFinishedEvent(this);
        }
    }
}
