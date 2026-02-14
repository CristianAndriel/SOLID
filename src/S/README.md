# S - Single Responsibility Principle (Princípio da Responsabilidade Única)

## 📖 Conceito

O **Single Responsibility Principle (SRP)** é o primeiro princípio do SOLID e estabelece que:

> **"Uma classe deve ter apenas uma razão para mudar."**

Isso significa que cada classe deve ser **especialista em apenas uma coisa** e ter **uma única responsabilidade** bem definida.

### Por que é importante?

- ✅ **Manutenibilidade**: Código mais fácil de entender e modificar
- ✅ **Testabilidade**: Classes menores são mais fáceis de testar
- ✅ **Reusabilidade**: Responsabilidades isoladas podem ser reutilizadas
- ✅ **Baixo acoplamento**: Mudanças em uma responsabilidade não afetam outras
- ✅ **Alta coesão**: Cada classe foca em fazer uma coisa muito bem

---

## 🎯 O Problema (Antes)

Imagine uma classe `User` que faz **tudo**:

```java
public class User {
    private String name;
    private String email;
    
    // Responsabilidade 1: Gerenciar dados do usuário
    public User(String name, String email) { ... }
    
    // Responsabilidade 2: Salvar no banco de dados
    public void save() {
        System.out.println("Salvando no banco...");
    }
    
    // Responsabilidade 3: Enviar email
    public void sendWelcomeEmail() {
        System.out.println("Enviando email...");
    }
}
```

### ❌ Problemas dessa abordagem:

1. **Múltiplas razões para mudar**: Se mudar o banco de dados, a lógica de email ou os atributos do usuário, a classe `User` precisa ser modificada
2. **Difícil de testar**: Para testar o envio de email, você precisa criar um usuário completo
3. **Difícil de reutilizar**: Se quiser usar o `EmailService` em outra parte do sistema, não consegue
4. **Violação do SRP**: A classe tem 3 responsabilidades diferentes

---

## ✅ A Solução (Implementação)

A solução é **separar cada responsabilidade em classes diferentes**:

### Estrutura de Arquivos

```
src/S/
  ├── User.java                    → Representa a entidade Usuário
  ├── Repository/
  │   └── UserRepository.java      → Responsável pela persistência
  └── Service/
      └── EmailService.java        → Responsável pelo envio de emails
```

---

### 1️⃣ **User.java** - Entidade

**Responsabilidade:** Representar a entidade Usuário (apenas dados)

```java
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
```

✅ Foca **apenas** em armazenar e fornecer acesso aos dados do usuário

---

### 2️⃣ **UserRepository.java** - Persistência

**Responsabilidade:** Salvar e recuperar usuários do banco de dados

```java
public class UserRepository {
    public void save(User user) {
        String name = user.getName();
        System.out.println("Salvando usuário: " + name + " no banco de dados");
    }
}
```

✅ Foca **apenas** em operações de persistência (banco de dados)

---

### 3️⃣ **EmailService.java** - Serviço de Email

**Responsabilidade:** Enviar emails relacionados a usuários

```java
public class EmailService {
    public void sendWelcomeEmail(User user) {
        String email = user.getEmail();
        System.out.println("Enviando email de boas-vindas para " + email);
    }
}
```

✅ Foca **apenas** em enviar emails

---

## 🚀 Como Usar

```java
public class S.Main {
    public static void main(String[] args) {
        // 1. Criar o usuário
        User user = new User("Cristian Silva", "cristian@email.com");
        
        // 2. Salvar no banco de dados
        UserRepository repository = new UserRepository();
        repository.save(user);
        
        // 3. Enviar email de boas-vindas
        EmailService emailService = new EmailService();
        emailService.sendWelcomeEmail(user);
    }
}
```

**Saída esperada:**
```
Salvando usuário: João Silva no banco de dados
Enviando email de boas-vindas para joao@email.com
```

---

## 🎓 Benefícios Alcançados

### ✅ Separação de Responsabilidades
Cada classe tem **uma única razão para mudar**:
- `User`: Muda se os atributos do usuário mudarem
- `UserRepository`: Muda se a forma de persistir dados mudar
- `EmailService`: Muda se a lógica de envio de email mudar

### ✅ Facilita Testes
Você pode testar cada classe independentemente:
```java
@Test
public void testEmailService() {
    User user = new User("Test", "test@email.com");
    EmailService service = new EmailService();
    service.sendWelcomeEmail(user); // Testa apenas o email
}
```

### ✅ Reutilização
O `EmailService` pode ser usado em outros contextos:
```java
emailService.sendPasswordResetEmail(user);
emailService.sendNotification(user, "Nova mensagem");
```

### ✅ Manutenção Simples
Para trocar o banco de dados, você só modifica o `UserRepository`. As outras classes não são afetadas!

---

## 📚 Conceitos Relacionados

- **Coesão**: O grau em que os elementos de uma classe pertencem juntos
- **Acoplamento**: O grau de dependência entre classes
- **Encapsulamento**: Ocultar detalhes de implementação

---

## 💡 Regra Prática

**Pergunte-se sempre:**

> "Se eu precisar mudar [X], quantas classes vou precisar modificar?"

Se a resposta for **mais de uma classe para uma única mudança**, você provavelmente está violando o SRP!

---

## 🎯 Conclusão

O **Single Responsibility Principle** nos ensina a criar classes **focadas e especializadas**. 

Em vez de uma classe "faz-tudo", temos:
- Classes **menores** e mais **compreensíveis**
- Código **mais fácil de testar** e **manter**
- Sistema **mais flexível** e **escalável**

**"Faça uma coisa, e faça bem feita!"** ✨

