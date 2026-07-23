package uce.edu.ec.application.service.interceptors;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import uce.edu.ec.application.service.AuditandoService;
import uce.edu.ec.application.service.VehiculoService;
import uce.edu.ec.domain.model.Auditando;
import uce.edu.ec.domain.model.Vehiculo;

@Auditar
@Interceptor
@Priority(1)
public class AuditarInterceptor {

    @Inject
    private AuditandoService as;

    @Inject
    private VehiculoService vs;

    @AroundInvoke
    public Object auditar(InvocationContext context) throws Exception {
        Auditando auditando = new Auditando();
        auditando.setPlaca(((Vehiculo) context.getParameters()[0]).getPlaca());
        auditando.setSelect(0);
        auditando.setInsert(0);
        auditando.setDelete(0);
        auditando.setUpdate(0);

        Vehiculo vehiculo = (Vehiculo) context.getParameters()[0];
        if (!auditando.getPlaca().equals(vehiculo.getPlaca())) {
            auditando.setSelect(1);
            as.guardar(auditando);

        } else {
            if (context.getMethod().getName().equals("actualizarVehiculoPorPlaca")) {
                auditando.setSelect(auditando.getSelect() + 1);
                as.guardar(auditando);
            } else if (context.getMethod().getName().equals("eliminarPorId")) {
                auditando.setDelete(auditando.getDelete() + 1);
                as.guardar(auditando);
            } else if (context.getMethod().getName().equals("guardar")) {
                auditando.setInsert(auditando.getInsert() + 1);
                as.guardar(auditando);
            }
        }

        return context.proceed();

    }

}
