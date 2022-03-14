/**
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author Clinton Begin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Options {
  /**
   * The options for the {@link Options#flushCache()}.
   * The default is {@link FlushCachePolicy#DEFAULT}
   */
  enum FlushCachePolicy {
    /** <code>false</code> for select statement; <code>true</code> for insert/update/delete statement. */
    DEFAULT,
    /** Flushes cache regardless of the statement type. */
    TRUE,
    /** Does not flush cache regardless of the statement type. */
    FALSE
  }
  /**
   * @describe: 是否使用缓存
   */
  boolean useCache() default true;
  /**
   * @describe: 是否刷新缓存
   */
  FlushCachePolicy flushCache() default FlushCachePolicy.DEFAULT;
  /**
   * @describe: 结果集的类型
   */
  ResultSetType resultSetType() default ResultSetType.DEFAULT;
  /**
   * @describe: 用哪种statement，决定了用哪种结果处理方式 StatementHandler
   */
  StatementType statementType() default StatementType.PREPARED;

  int fetchSize() default -1;

  int timeout() default -1;

  boolean useGeneratedKeys() default false;

  String keyProperty() default "";

  String keyColumn() default "";

  String resultSets() default "";
}
