/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.lang.Nullable;

/**
 * Subinterface of {@link BeanPostProcessor} that adds a before-instantiation callback,
 * and a callback after instantiation but before explicit properties are set or
 * autowiring occurs.
 *
 * <p>Typically used to suppress default instantiation for specific target beans,
 * for example to create proxies with special TargetSources (pooling targets,
 * lazily initializing targets, etc), or to implement additional injection strategies
 * such as field injection.
 *
 * <p><b>NOTE:</b> This interface is a special purpose interface, mainly for
 * internal use within the framework. It is recommended to implement the plain
 * {@link BeanPostProcessor} interface as far as possible, or to derive from
 * {@link InstantiationAwareBeanPostProcessorAdapter} in order to be shielded
 * from extensions to this interface.
 *
 * @author Juergen Hoeller
 * @author Rod Johnson
 * @since 1.2
 * @see org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#setCustomTargetSourceCreators
 * @see org.springframework.aop.framework.autoproxy.target.LazyInitTargetSourceCreator
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

	/**
	 * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.  在目标 bean 实例化之前应用此 BeanPostProcessor
	 * The returned bean object may be a proxy to use instead of the target bean,   返回的 bean 对象可能是要使用的代理，而不是目标 bean，
	 * effectively suppressing default instantiation of the target bean.   有效抑制目标bean的默认实例化
	 * <p>If a non-null object is returned by this method, the bean creation process  如果此方法返回非空对象，则bean创建过程
	 * will be short-circuited. The only further processing applied is the   会短路。 唯一应用的进一步处理是
	 * {@link #postProcessAfterInitialization} callback from the configured    {@link #postProcessAfterInitialization} 来自配置的回调
	 * {@link BeanPostProcessor BeanPostProcessors}.                            {@link BeanPostProcessor BeanPostProcessors}。
	 * <p>This callback will be applied to bean definitions with their bean class,   这个回调将应用到 bean定义及其 beanClass，
	 * as well as to factory-method definitions in which case the returned bean type   以及在这种情况下返回的 bean 类型的工厂方法定义
	 * will be passed in here.                                                         将在这里传递。
	 * <p>Post-processors may implement the extended                                   后处理器可以实现扩展
	 * {@link SmartInstantiationAwareBeanPostProcessor} interface in order              {@link SmartInstantiationAwareBeanPostProcessor} 接口顺序
	 * to predict the type of the bean object that they are going to return here.        预测他们将在此处返回的 bean 对象的类型。
	 * <p>The default implementation returns {@code null}.                                默认实现返回null
	 * @param beanClass the class of the bean to be instantiated                            要实例化的 bean的类
	 * @param beanName the name of the bean
	 * @return the bean object to expose instead of a default instance of the target bean,    要公开的 bean 对象，而不是目标 bean 的默认实例
	 * or {@code null} to proceed with default instantiation                                  继续默认实例化
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see #postProcessAfterInstantiation
	 * @see org.springframework.beans.factory.support.AbstractBeanDefinition#getBeanClass()
	 * @see org.springframework.beans.factory.support.AbstractBeanDefinition#getFactoryMethodName()
	 */
	@Nullable
	default Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		return null;
	}

	/**
	 * Perform operations after the bean has been instantiated, via a constructor or factory method,  在 bean 实例化后通过构造函数或工厂方法执行操作
	 * but before Spring property population (from explicit properties or autowiring) occurs.  但在 Spring 属性填充（来自显式属性或自动装配）发生之前
	 * <p>This is the ideal callback for performing custom field injection on the given bean   这是在给定 bean 上执行自定义字段注入的理想回调
	 * instance, right before Spring's autowiring kicks in.   例如，就在 Spring 的自动装配开始之前。
	 * <p>The default implementation returns {@code true}.               默认实现返回 {@code true}
	 * @param bean the bean instance created, with properties not having been set yet   创建的 bean 实例，尚未设置属性**********
	 * @param beanName the name of the bean
	 * @return {@code true} if properties should be set on the bean; {@code false}          return true 如果应该在 bean上设置属性
	 * if property population should be skipped. Normal implementations should return {@code true}.   return false; 如果property population 应该被跳过。 正常的实现应该返回true
	 * Returning {@code false} will also prevent any subsequent InstantiationAwareBeanPostProcessor  返回false 也将阻止任何后续的InstantiationAwareBeanPostProcessor
	 * instances being invoked on this bean instance.   在此 bean 实例上调用的实例
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see #postProcessBeforeInstantiation
	 */
	default boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		return true;
	}

	/**
	 * Post-process the given property values before the factory applies them  在工厂应用它们之前对给定的属性值进行后处理
	 * to the given bean, without any need for property descriptors.                            到给定的 bean，不需要任何属性描述符
	 * <p>Implementations should return {@code null} (the default) if they provide a custom     如果提供自定义的实现应该返回null （默认）
	 * {@link #postProcessPropertyValues} implementation, and {@code pvs} otherwise.
	 * In a future version of this interface (with {@link #postProcessPropertyValues} removed),
	 * the default implementation will return the given {@code pvs} as-is directly.
	 * @param pvs the property values that the factory is about to apply (never {@code null})
	 * @param bean the bean instance created, but whose properties have not yet been set
	 * @param beanName the name of the bean
	 * @return the actual property values to apply to the given bean (can be the passed-in
	 * PropertyValues instance), or {@code null} which proceeds with the existing properties
	 * but specifically continues with a call to {@link #postProcessPropertyValues}
	 * (requiring initialized {@code PropertyDescriptor}s for the current bean class)
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @since 5.1
	 * @see #postProcessPropertyValues
	 */
	@Nullable
	default PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
			throws BeansException {

		return null;
	}

	/**
	 * Post-process the given property values before the factory applies them
	 * to the given bean. Allows for checking whether all dependencies have been
	 * satisfied, for example based on a "Required" annotation on bean property setters.
	 * <p>Also allows for replacing the property values to apply, typically through
	 * creating a new MutablePropertyValues instance based on the original PropertyValues,
	 * adding or removing specific values.
	 * <p>The default implementation returns the given {@code pvs} as-is.
	 * @param pvs the property values that the factory is about to apply (never {@code null})
	 * @param pds the relevant property descriptors for the target bean (with ignored
	 * dependency types - which the factory handles specifically - already filtered out)
	 * @param bean the bean instance created, but whose properties have not yet been set
	 * @param beanName the name of the bean
	 * @return the actual property values to apply to the given bean (can be the passed-in
	 * PropertyValues instance), or {@code null} to skip property population
	 * @throws org.springframework.beans.BeansException in case of errors
	 * @see #postProcessProperties
	 * @see org.springframework.beans.MutablePropertyValues
	 * @deprecated as of 5.1, in favor of {@link #postProcessProperties(PropertyValues, Object, String)}
	 */
	@Deprecated
	@Nullable
	default PropertyValues postProcessPropertyValues(
			PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

		return pvs;
	}

}
