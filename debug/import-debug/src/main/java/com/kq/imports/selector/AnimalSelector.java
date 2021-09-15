package com.kq.imports.selector;

import com.kq.imports.service.impl.Cat;
import com.kq.imports.service.impl.Dog;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author kq
 * @date 2020-10-16 16:50
 * @since 2020-0630
 */
public class AnimalSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {Cat.class.getName(), Dog.class.getName()} ;
    }
}
