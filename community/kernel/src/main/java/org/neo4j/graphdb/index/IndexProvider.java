/**
 * Copyright (c) 2002-2013 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.graphdb.index;

import org.neo4j.graphdb.DependencyResolver;
import org.neo4j.helpers.Service;

/**
 * IndexProvider has been replaced with KernelExtensions. Essentially, an extension implementing IndexImplementations
 * should provide a KernelExtensionFactory whose KernelExtension on start() creates and registers an IndexImplementation
 * with the IndexProviders collection. See LuceneKernelExtension for an example of this.
 */
@Deprecated
public abstract class IndexProvider extends Service
{
    private final String identifier;

    public IndexProvider( String identifier )
    {
        super( identifier );
        this.identifier = identifier;
    }

    public abstract IndexImplementation load( DependencyResolver dependencyResolver) throws Exception;

    public final String identifier()
    {
        return identifier;
    }
}