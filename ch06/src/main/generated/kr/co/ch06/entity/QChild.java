package kr.co.ch06.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChild is a Querydsl query type for Child
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChild extends EntityPathBase<Child> {

    private static final long serialVersionUID = 1489628217L;

    public static final QChild child = new QChild("child");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath cid = createString("cid");

    public final StringPath name = createString("name");

    public final StringPath pid = createString("pid");

    public QChild(String variable) {
        super(Child.class, forVariable(variable));
    }

    public QChild(Path<? extends Child> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChild(PathMetadata metadata) {
        super(Child.class, metadata);
    }

}

