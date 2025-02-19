  @public List<Advertisement> findByKeyword(String keyword) {
        String sql = getBaseQuery() + " WHERE ad.TITLE LIKE ? OR ad.TEXT LIKE ? ORDER BY ad.CREATE_DATE DESC";
        String wildcard = "%" + keyword + "%";
        // Use PreparedStatement to prevent SQL Injection
        return this.jdbcTemplate.queryForList(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, wildcard);
                preparedStatement.setString(2, wildcard);
            }
        });
    }

