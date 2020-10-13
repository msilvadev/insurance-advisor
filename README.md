# Insurance Advisor Application

Parâmetros adicionais para o GC, para evitar efeitos 'colaterais', do FullGC após a inicialização da aplicação:
`-Xms512m -Xmx512m -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses -XX:+UseConcMarkSweepGC` 