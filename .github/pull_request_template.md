### O que foi feito?

### Orientações aos Revisores:

### Estou de acordo que:

1. Nomenclatura e Organização
- [ ] Nomes descritivos
<!--- Verifique se variáveis, componentes e funções têm nomes claros e autoexplicativos. Evite abreviações desnecessárias. -->
- [ ] Estrutura do código
<!--- Certifique-se de que o código segue uma estrutura organizada, com componentes bem separados, lógica em hooks apropriados e uma clara separação de responsabilidades. -->

2. Tratamento de Erros e Exceções
- [ ] Tratamento de erros
<!--- Verifique se exceções são tratadas adequadamente e se o código não está deixando erros passarem silenciosamente. -->

3. Ciclo de Vida dos Componentes
- [ ] Hooks de ciclo de vida
<!--- Certifique-se de que os hooks (como useEffect) estão sendo usados corretamente e que o código respeita o ciclo de vida dos componentes. -->
- [ ] Operações pesadas
<!--- Evite operações pesadas no render ou dentro de useEffect sem a devida gestão de dependências. -->

4. Boas Práticas de Interface de Usuário (UI)
- [ ] Consistência de Layouts
<!--- Verifique se os layouts seguem as melhores práticas de design (como o Material UI) e se as unidades de medida são usadas corretamente. -->
- [ ] Props significativas nos componentes
<!--- Os nomes das props devem ser claros e representativos. -->
- [ ] Suporte a diferentes tamanhos de tela
<!--- Verifique se o layout é responsivo, utilizando CSS flexbox ou grid e evitando valores hardcoded. -->

5. Uso Adequado de Recursos (Strings, Cores, etc.)
- [ ] Strings
<!--- Verifique se os textos da interface estão em arquivos de configuração (como um arquivo de constantes ou i18n), mesmo que a internacionalização não esteja implementada ainda. -->
- [ ] Cores e estilos
<!--- Certifique-se de que as cores e estilos estão sendo usados através de arquivos de estilos (CSS, SCSS, etc.) e não hardcoded no código. -->

6. Dependências e Bibliotecas
- [ ] Verificar dependências desatualizadas
<!--- Certifique-se de que as dependências no package.json estão atualizadas. -->
- [ ] Evitar bibliotecas desnecessárias
<!--- Verifique se bibliotecas que não são mais usadas foram removidas e se não há dependências desnecessárias no projeto. -->

7. Configurações de Ambiente
- [ ] Configuração de variáveis de ambiente
<!--- Verifique se as variáveis de ambiente estão configuradas corretamente e se o código não contém credenciais hardcoded. -->

8. Acessibilidade
- [ ] Considerações de acessibilidade
<!--- Verifique se os componentes estão acessíveis (uso de roles, aria-labels, etc.) e se a navegação é amigável para leitores de tela. -->
