package util;
//callback是回调函数,可以在函数执行时动态的绑定上下文
public interface CallBack {
	//正常情况下this对象是根据运行上下文自动指定的。
	//但是用call方法可以手动设置上下文。相当于可以随意调整函数中的this对象指向谁
	public void call();
}
