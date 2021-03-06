package com.lkl.demo.https.util

import com.lkl.demo.bean.ResultData
import com.lkl.demo.https.HttpSimpleSubscriber
import com.lkl.demo.https.HttpSimpleTransformer
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Observable

fun <T : Any, E> Observable<ResultData<T>>.compose1(lifecycleProvider: LifecycleProvider<E>? = null,
                                                    needCertification: Boolean = false,
                                                    httpSimpleSubscriber: HttpSimpleSubscriber<T>? = null): Observable<T> =
        compose(HttpSimpleTransformer(lifecycleProvider, needCertification, httpSimpleSubscriber))